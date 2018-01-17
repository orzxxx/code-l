package test.boot.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import schemacrawler.schema.Catalog;
import schemacrawler.schema.PrimaryKey;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.DatabaseConnectionOptions;
import schemacrawler.schemacrawler.ExcludeAll;
import schemacrawler.schemacrawler.RegularExpressionInclusionRule;
import schemacrawler.schemacrawler.SchemaCrawlerException;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaInfoLevelBuilder;
import schemacrawler.utility.SchemaCrawlerUtility;
import test.boot.dao.DatasourceDao;
import test.boot.entity.tables.pojos.Datasource;
import test.boot.model.table.ColumnInfo;
import test.boot.model.table.SchemaInfo;
import test.boot.model.table.TableInfo;
import test.boot.service.DatabaseService;

@Service
@Transactional
public class DatabaseServiceImpl implements DatabaseService {
	
	@Autowired
	private DatasourceDao datasourceDao;
	
	public List<SchemaInfo> listSchemaByDatasourceId(int dId) throws Exception {
		final Datasource datasource = datasourceDao.get(dId);
		
		// TODO 只试过mysql
		Connection conn = getConnection(datasource);
		SchemaCrawlerOptions options = getSchemaCrawlerOptions(conn);
		
 	    Catalog catalog = SchemaCrawlerUtility.getCatalog(conn,options);
 	    Collection<Schema> schemas = catalog.getSchemas();
 	    
		/*Collection<Table> tables = schemas.stream()
				.map(s -> {
					return catalog.getTables(s);
				}).flatMap(Collection::stream)
				.collect(Collectors.toList());*/
		
		//TODO 判断schemaName空?
		List<SchemaInfo> result = schemas.stream()
				.map(s -> {
					SchemaInfo schemaInfo = new SchemaInfo();
					schemaInfo.setName(s.getCatalogName());
					schemaInfo.setTableInfos(getTableInfos(datasource.getName(), catalog, s));

					return schemaInfo;
				}).collect(Collectors.toList());
		
    	return result;
	}

	private static Connection getConnection(Datasource datasource)
			throws SchemaCrawlerException, SQLException {
		return new DatabaseConnectionOptions(datasource.getUrl())
				.getConnection(datasource.getUsername(), datasource.getPassword());
	}
	
	private SchemaCrawlerOptions getSchemaCrawlerOptions(Connection conn) throws SQLException {
		SchemaCrawlerOptions options = new SchemaCrawlerOptions();
 	    options.setSchemaInfoLevel(SchemaInfoLevelBuilder.standard());
 	    options.setRoutineInclusionRule(new ExcludeAll());
 	    options.setSchemaInclusionRule(
 	    		new RegularExpressionInclusionRule(conn.getCatalog()));
 	    
 	    return options;
	}
	
	private List<TableInfo> getTableInfos(String datasourceName, Catalog catalog, Schema schema) {
		return catalog.getTables(schema).stream().map(t -> {
			TableInfo tableInfo = new TableInfo();
			tableInfo.setId(datasourceName + "." + schema.getCatalogName() + "." + t.getName());
			tableInfo.setName(t.getName());
			tableInfo.setColumns(getColumnInfos(t));
			return tableInfo;
		}).collect(Collectors.toList());
	}

	private List<ColumnInfo> getColumnInfos(Table table) {
		PrimaryKey pk = table.getPrimaryKey();
		String[] keys = pk == null ? new String[]{} : table.getPrimaryKey().getColumns().stream()
				.map(c -> c.getName())
				.toArray(String[]::new);
		
		return table.getColumns().stream().map(c -> {
			ColumnInfo columnInfo = new ColumnInfo();
			columnInfo.setKey(Stream.of(keys).anyMatch(c.getName()::equals) ? true : false);
			columnInfo.setType(c.getType().getName().split(" ")[0]); // 类似DECIMAL UNSIGNED, 不关心符号
			columnInfo.setDefaultValue(getColumnDefaultValue(c.getDefaultValue()));
			columnInfo.setLength(c.getSize());
			columnInfo.setNullable(c.getType().isNullable());
			columnInfo.setScale(c.getDecimalDigits());
			columnInfo.setName(c.getName());
			columnInfo.setComment(c.getRemarks());
			
			return columnInfo;
		}).collect(Collectors.toList());
	}

	/**
	 * 名字太长缩短
	 * @param defaultValue
	 * @return
	 */
	private Object getColumnDefaultValue(String defaultValue) {
		String result = defaultValue;
		
		if (StringUtils.isEmpty(defaultValue)) {
			return result;
		}
		
		if (defaultValue.equals("CURRENT_TIMESTAMP")) {
			return "CURRENT";
		}
		
		return result;
	}
}
