/*package test.boot.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.Field;
import org.jooq.Key;
import org.jooq.Meta;
import org.jooq.SQLDialect;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.boot.dao.TProdInfoDao;
import test.boot.entry.mysql.tables.records.TProdInfoRecord;
import test.boot.model.ColumnInfo;
import test.boot.model.SchemaInfo;
import test.boot.model.TableInfo;
import test.boot.service.impl.ProdInfoServiceImpl;

@RestController
public class ForTestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TProdInfoDao tProdInfoDao;
	
	@Autowired
	private ProdInfoServiceImpl impl;
	
    @RequestMapping("/")
    public String home() {
    	//int i = 4 / 0;
        return "Hello World";
    }
    
    @RequestMapping("/t")
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
    }
}
*/