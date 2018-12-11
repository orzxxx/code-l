package test.boot.custom;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.alibaba.fastjson.JSON;

public class ClassAnalysis {
	
	public static String toJson(Class clazz) throws Exception {
		Object bean = clazz.newInstance();
		List<Field> fields = getAllFields(clazz);
		fields.stream().forEach(f -> {
			try {
				f.setAccessible(true);
				if (f.getType().equals(Integer.class)) {
					f.setInt(bean, (int) Math.random() * 100);
				} else if (f.getType().equals(Double.class)) {
					f.setDouble(bean, Math.random() * 10);
				} else if (f.getType().equals(String.class)) {
					f.set(bean, f.getName());
				} else if (f.getType().equals(Date.class)) {
					f.set(bean, DateUtils.addDays(new Date(), -new Random().nextInt(1000)));
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		
		return JSON.toJSONString(Arrays.asList(bean));
	}
	
	private static List<Field> getAllFields(Class clazz) {
		List<Field> result = new ArrayList<>();
		while (clazz != null){
		    result.addAll(new ArrayList<Field>(Arrays.asList(clazz.getDeclaredFields())));
		    clazz = clazz.getSuperclass();
		}
		
		return result;
	}
	
	public static String toXyXml(Class clazz, String serviceName) throws Exception {
		List<String> result = new ArrayList<>();
		result.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		result.addAll(createClassStr(clazz, 0, serviceName));
		return result.stream().reduce("", (t, n) -> t + n + "\r\n");
	}
	
	private static List<String> createClassStr(Class clazz, int level, String serviceName) throws Exception {
		List<String> result = new ArrayList<>();
		result.add(createTabs(level) + "<" + createClassName(clazz, level, serviceName) 
				+ (level == 0 ? " xmlns=\"http://www.xyzq.com.cn/schema/" + serviceName + "/1.0.0\"" : "")
				+ ">");
		Field[] fs = clazz.getDeclaredFields(); // 不考虑父类
		for (Field f : fs) {
			if (isBaseClass(f.getType())) {
				result.add(printField(f, level + 1));
			} else if (f.getType().equals(List.class)) {
				ParameterizedType genericType = (ParameterizedType) f.getGenericType();
				result.addAll(createClassStr((Class<?>) genericType.getActualTypeArguments()[0], level + 1, serviceName));
			} else {
				result.addAll(createClassStr(f.getType(), level + 1, serviceName));
			}
		}
		result.add(createTabs(level) + "</" + createClassName(clazz, level, serviceName) + ">");
		return result;
	}
	
	private static String createClassName(Class clazz, int level, String serviceName) {
		String result = clazz.getSimpleName();
		if (level == 0 && result.endsWith("InType")) {
			return result.substring(0, result.length() - 6) + "In";
		}
		return result;
	}
	
	private static String createTabs(int count) {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += "\t";
		}
		return result;
	}
	
	private static String printField(Field field, int level) throws Exception {
		if (isPrimitiveOrNumber(field.getType())) {
			return createTabs(level) + createFieldStr(field, String.valueOf(new Random().nextInt(1000)));
		} else if (field.getType().equals(XMLGregorianCalendar.class)) {
			return createTabs(level) + createFieldStr(field, createRandomXMLGregorianCalendarStr());
		} 
		
		return "";
	}
	
	private static String createRandomXMLGregorianCalendarStr() throws Exception{
		GregorianCalendar cal = new GregorianCalendar();
	    cal.setTime(DateUtils.addDays(new Date(), -new Random().nextInt(1000)));
	    return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal).toString();
	}
	
	private static boolean isBaseClass(Class clazz) {
		return isPrimitiveOrNumber(clazz)
				|| clazz.equals(XMLGregorianCalendar.class);
	}
	
	private static boolean isPrimitiveOrNumber(Class clazz) {
		return clazz.equals(String.class)
				|| ClassUtils.isPrimitiveOrWrapper(clazz)
				|| clazz.equals(BigInteger.class)
				|| clazz.equals(BigDecimal.class);
	}
	
	private static String createFieldStr(Field field, String value) {
		String fieldName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
		return "<" + fieldName + ">" + value + "</" + fieldName + ">"; 
	}
}
