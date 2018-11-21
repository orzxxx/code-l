package test.boot;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import test.boot.core.SimpleCodeGenerator;
import test.boot.custom.ClassAnalysis;
import cn.com.xyzq.schema.financeproductservicedc._1_0.PublishProdAllocationInfoInType;

public class LTest {
	
	@Test
	public void class1() throws Exception {
		SimpleCodeGenerator codeGenerator = new SimpleCodeGenerator("mid-lr");
		
		Map<String, Object> binding = new HashMap<>();
		binding.put("className", "AAA");
		binding.put("esbClass", "BBB");
		binding.put("service", "CCC");
		binding.put("data", ClassAnalysis.toXyXml(PublishProdAllocationInfoInType.class, "FinanceProductServiceDC"));
		codeGenerator.generate(binding);
	}
}
