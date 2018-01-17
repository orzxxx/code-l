package test.boot.controller;

import groovy.lang.Writable;
import groovy.text.GStringTemplateEngine;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.ResultQuery;
import org.jooq.SQLDialect;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.boot.dao.TemplateDao;
import test.boot.entity.tables.pojos.Template;
import test.boot.model.table.ColumnVariable;
import test.boot.model.table.NameVariable;
import test.boot.model.table.SchemaInfo;
import test.boot.model.table.TableInfo;
import test.boot.model.table.TableVariable;

@RestController
public class ForTestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TemplateDao templateDao;
	
	@Autowired
	private DSLContext create;
	
	private Map tableMap = new HashMap();
	
	/*@Autowired
	private ProdInfoServiceImpl impl;*/
	
   /*@RequestMapping("/test/tmpl")
    public String home() throws CompilationFailedException, ClassNotFoundException, IOException {
    	TTemplate t = templateDao.get(3);
    	GStringTemplateEngine engine = new GStringTemplateEngine();
    	List<String> l = new ArrayList<>();
    	l.add("aaaa");
    	l.add("bbbb");
    	Map binding = new HashMap();
    	binding.put("firstname", "f11111");
    	binding.put("lastname", 22222);
    	binding.put("city", "cityhaha");
    	binding.put("n1", 10);
    	binding.put("n2", 25);
    	T bean = new T();
    	bean.name = "中文";
    	bean.strs = l;
    	binding.put("bean", bean);
    	Dear "$firstname $lastname",
    	So nice to meet you in <% out << (city == "New York" ? "\\"The Big Apple\\"" : city) %>.
    	See you in ${month},
    	${signed}
    	//GStringTemplateEngine
    	//GString
    	//GString gstr = new GString(t.getContent());
    	//GStringImpl g = GStringImpl();
    	VariableExpressionTransformer v = new VariableExpressionTransformer();
    	GStringExpression e = new GStringExpression(t.getContent());
    	System.out.println(e.getText());
    	System.out.println(e);
    	Template template = engine.createTemplate(t.getContent());
    	Writable w = template.make(binding);
    	w.toString();
    	//System.out.println(engine.createTemplate(t.getContent()).make(binding).toString());
    	//int i = 4 / 0;
    	//w.toString();
        return "1";
    }*/
    
    @RequestMapping("/test/tmpl2")
    public String t1() throws Exception {
    	matedate();
    	List<Template> ts = templateDao.list();
    	ts.forEach((t) -> {
    		String fileName = t.getFileName();
    		String content = t.getContent();
    		String filePath = t.getFilePath();
    		GStringTemplateEngine engine = new GStringTemplateEngine();
    		Map binding = new HashMap();
        	try {
				binding.put("t", tables("t_template_group"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	groovy.text.Template template;
			try {
				template = engine.createTemplate(content);
				Writable w = template.make(binding);
				content = w.toString();
	        	System.out.println(content);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
			groovy.text.Template template2;
			try {
				template2 = engine.createTemplate(fileName);
				Writable w2 = template2.make(binding);
				fileName = w2.toString();
	        	System.out.println(fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			groovy.text.Template template3;
			try {
				template3 = engine.createTemplate(t.getFilePath());
				Writable w3 = template3.make(binding);
				filePath = w3.toString();
				System.out.println(filePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				FileUtils.writeStringToFile(
						new File("./template/" + filePath.replace(".", "/") + "/" + fileName), content, "utf-8");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
    	});
    	return "1";
    }
    
    @RequestMapping("/test/tmpl3")
    public String t3() throws Exception {
    	try {
    		matedate();
    		Map binding = new HashMap();
    		TableVariable t = (TableVariable) tables("t_template_group");
			binding.put("t", t);
			System.out.println(t.columns.size());
			GStringTemplateEngine engine = new GStringTemplateEngine();
			String tmpl = FileUtils.readFileToString(new File("./template/tempD.txt"));
			groovy.text.Template template;
    			template = engine.createTemplate(tmpl);
    			Writable w = template.make(binding);
    			System.out.println(w);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
    	return "t3";
    }
    
    private Object matedate() throws SQLException, DataAccessException {
    	Connection connection = 
    	        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/datasync", "root","root");
    	DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
    	System.out.println(connection.getCatalog());
    	ResultQuery<Record> resultQuery = create.resultQuery("SELECT * FROM tbl_mtms_app_inf");
    	create.createSchema("datasync");
    	//create.informationSchema(catalog)
    	//create.mete().
    	String database = connection.getCatalog();
		List<Schema> schemas = create.meta().getSchemas().stream()
				.filter(s -> s.getName().equals(database))
				.collect(Collectors.toList());
		List<Table> tables = schemas.stream()
				.map(Schema::getTables)
				.flatMap(List::stream)
				.collect(Collectors.toList());
		tableMap = tables.stream().collect(Collectors.toMap(Table::getName, t -> t));
		List<TableInfo> tableInfos = tables.stream()
				.map(t -> {
					TableInfo tableInfo = new TableInfo();
					tableInfo.setName(t.getName());
					return tableInfo;
				})
				.collect(Collectors.toList());
		
		SchemaInfo schemaInfo = new SchemaInfo();
		schemaInfo.setName(connection.getCatalog());
		schemaInfo.setTableInfos(tableInfos);
		
		List<SchemaInfo> result = new ArrayList<>();
		result.add(schemaInfo);
    	return result;
    }
    
    Object tables(String name) throws SQLException, DataAccessException {
    	Table r = (Table) tableMap.get(name);
    	
		String[] keys = Stream.of(r.getPrimaryKey() != null 
						? r.getPrimaryKey().getFieldsArray() 
						: new Field[] {})
				.map(Field::getName)
				.toArray(String[]::new);
    	
    	List<ColumnVariable> columnInfos = Stream.of(r.fields()).map(f -> {
    		DataType dataType = f.getDataType();
    		ColumnVariable columnInfo = new ColumnVariable(new NameVariable(f.getName()));
    		columnInfo.setKey(Stream.of(keys).anyMatch(f.getName()::equals) ? true : false);
    		columnInfo.setType(dataType.getTypeName());
    		columnInfo.setDefaultValue(dataType.defaultValue());
    		columnInfo.setLength(dataType.length());
    		columnInfo.setNullable(dataType.nullable());
    		columnInfo.setScale(dataType.scale());
    		columnInfo.setComment(f.getComment());
    		return columnInfo;
    	}).collect(Collectors.toList());
    	
    	TableVariable tableInfo = new TableVariable(new NameVariable(r.getName()));
    	tableInfo.setColumns(columnInfos);
    	return tableInfo;
    }
    /*@RequestMapping("/t")
    void t() {
    	impl.transaction();
    }
    
    @RequestMapping("/list")
    Object list() {
    	logger.info("list=======================");
    	return tProdInfoDao.list();
    }
    
    @RequestMapping("/page")
    Object page() {
    	return tProdInfoDao.page(1, 2);
    }
    
    @RequestMapping("/get")
    Object get() {
    	return tProdInfoDao.get("TG0044370");
    }
    
    @RequestMapping("/save")
    Object save() {
    	TProdInfoRecord record = new TProdInfoRecord("1", new Timestamp(new Date().getTime()));
    	return tProdInfoDao.save(record);
    }
    
    @RequestMapping("/batchsave")
    Object batchsave() {
    	TProdInfoRecord record1 = new TProdInfoRecord("2", new Timestamp(new Date().getTime()));
    	TProdInfoRecord record2 = new TProdInfoRecord("3", new Timestamp(new Date().getTime()));
    	List<TProdInfoRecord> records = new ArrayList<TProdInfoRecord>();
    	records.add(record1);
    	records.add(record2);
    	return tProdInfoDao.save(records);
    }
    
    @RequestMapping("/update")
    Object update() {
    	TProdInfoRecord record = new TProdInfoRecord("1", new Timestamp(new Date().getTime()));
    	return tProdInfoDao.update(record);
    }
    
    @RequestMapping("/remove")
    Object remove() {
    	return tProdInfoDao.remove("1");
    }
    
    private Map<String, Table> tableMap = new HashMap<>();
    
    @RequestMapping("/matedate")
    Object matedate() throws SQLException, DataAccessException {
    	Connection connection = 
    	        DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/datasync", "root","root");
    	DSLContext create = DSL.using(connection, SQLDialect.MYSQL);
    	System.out.println(connection.getCatalog());
    	ResultQuery<Record> resultQuery = create.resultQuery("SELECT * FROM tbl_mtms_app_inf");
    	Result<Record> result = resultQuery.fetch();
    	create.createSchema("datasync");
    	//create.informationSchema(catalog)
    	//create.mete().
    	String database = connection.getCatalog();
		List<Schema> schemas = create.meta().getSchemas().stream()
				.filter(s -> s.getName().equals(database))
				.collect(Collectors.toList());
		List<Table> tables = schemas.stream()
				.map(Schema::getTables)
				.flatMap(List::stream)
				.collect(Collectors.toList());
		tableMap = tables.stream().collect(Collectors.toMap(Table::getName, t -> t));
		List<TableInfo> tableInfos = tables.stream()
				.map(t -> {
					TableInfo tableInfo = new TableInfo();
					tableInfo.setName(t.getName());
					return tableInfo;
				})
				.collect(Collectors.toList());
		
		SchemaInfo schemaInfo = new SchemaInfo();
		schemaInfo.setName(connection.getCatalog());
		schemaInfo.setTableInfos(tableInfos);
		
		List<SchemaInfo> result = new ArrayList<>();
		result.add(schemaInfo);
    	return result;
    }
    
    @RequestMapping("/tables/{name}")
    Object tables(@PathVariable String name) throws SQLException, DataAccessException {
    	Table r = tableMap.get(name);
    	
		String[] keys = Stream.of(r.getPrimaryKey() != null 
						? r.getPrimaryKey().getFieldsArray() 
						: new Field[] {})
				.map(Field::getName)
				.toArray(String[]::new);
    	
    	List<ColumnInfo> columnInfos = Stream.of(r.fields()).map(f -> {
    		DataType dataType = f.getDataType();
    		ColumnInfo columnInfo = new ColumnInfo();
    		columnInfo.setKey(Stream.of(keys).anyMatch(f.getName()::equals) ? true : false);
    		columnInfo.setType(dataType.getTypeName());
    		columnInfo.setDefaultValue(dataType.defaultValue());
    		columnInfo.setLength(dataType.length());
    		columnInfo.setNullable(dataType.nullable());
    		columnInfo.setScale(dataType.scale());
    		columnInfo.setName(f.getName());
    		columnInfo.setComment(f.getComment());
    		return columnInfo;
    	}).collect(Collectors.toList());
    	
    	TableInfo tableInfo = new TableInfo();
    	tableInfo.setName(r.getName());
    	tableInfo.setColumns(columnInfos);
    	
    	return tableInfo;
    }*/
}
