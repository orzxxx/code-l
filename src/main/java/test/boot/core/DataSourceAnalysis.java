package test.boot.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.commons.collections4.CollectionUtils;

import schemacrawler.schema.Catalog;
import schemacrawler.schema.PrimaryKey;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.RegularExpressionInclusionRule;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaCrawlerOptionsBuilder;
import schemacrawler.schemacrawler.SchemaInfoLevelBuilder;
import schemacrawler.utility.SchemaCrawlerUtility;
import test.boot.core.table.ColumnInfo;
import test.boot.core.table.ColumnVariable;
import test.boot.core.table.NameVariable;
import test.boot.core.table.TableInfo;
import test.boot.core.table.TableVariable;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class DataSourceAnalysis {
	
	public TableVariable datasoucreAnalyse(DataSource datasource, TableQueryInfo tableQry) {
		return datasoucreAnalyse(datasource, Arrays.asList(tableQry)).get(0);
	}
	
	public List<TableVariable> datasoucreAnalyse(DataSource datasource, List<TableQueryInfo> tableQrys) {
		// 整合相同schema
		ListMultimap<String, String> schemaToTables = ArrayListMultimap.create();
		tableQrys.forEach(t -> {
			schemaToTables.put(t.getSchema(), t.getTable());
		});
		
		// TODO 找不到
		return schemaToTables
				.asMap()
				.entrySet()
				.stream()
				.map(e -> {
					try {
						String schema = e.getKey();
						List<String> tableNames = new ArrayList<>(e.getValue());
						Connection conn = datasource.getConnection();
						SchemaCrawlerOptions options = getSchemaCrawlerOptions(
								conn, schema, new ArrayList<>(tableNames));
						Catalog catalog = SchemaCrawlerUtility.getCatalog(conn, options);
						Collection<Schema> schemas = catalog.getSchemas();
						return schemas
								.stream()
								.flatMap(sc -> getTableVariables(catalog, sc, tableQrys).stream())
								.collect(Collectors.toList());
					} catch (Exception ex) {
						ex.printStackTrace();
						throw new RuntimeException(ex);
					}
				})
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}
	
	private String getSchemaName(Schema schema) {
		return schema.getCatalogName() == null ? schema.getName() : schema.getCatalogName();
	}
	
	private SchemaCrawlerOptions getSchemaCrawlerOptions(Connection conn, 
			String schemaName, List<String> tableNames) throws SQLException {
		// schema.table
		List<String> fullNames = tableNames.stream()
				.map(tn -> (schemaName + "."  + tn).toUpperCase())
				.collect(Collectors.toList());
		SchemaCrawlerOptionsBuilder optionsBuilder = SchemaCrawlerOptionsBuilder
			      .builder()
			      .withSchemaInfoLevel(SchemaInfoLevelBuilder.standard())
			      .includeSchemas(new RegularExpressionInclusionRule("(?i)" + schemaName))
			      .includeTables(tn -> fullNames.contains(tn.toUpperCase()));
		return optionsBuilder.toOptions();
	}
	
	private List<TableVariable> getTableVariables(Catalog catalog, Schema schema, 
			List<TableQueryInfo> tableQrys) {
		return catalog.getTables(schema).stream().map(t -> {
			TableInfo tableInfo = new TableInfo();
			tableInfo.setName(t.getName());
			tableInfo.setSchema(getSchemaName(schema));
			tableInfo.setColumns(getColumnInfos(t));
			
			return getTableVariable(tableInfo, tableQrys);
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
			columnInfo.setType(c.getType().getName());
			columnInfo.setDefaultValue(c.getDefaultValue());
			columnInfo.setLength(c.getSize());
			columnInfo.setNullable(c.getType().isNullable());
			columnInfo.setScale(c.getDecimalDigits());
			columnInfo.setName(c.getName());
			columnInfo.setComment(c.getRemarks());
			
			return columnInfo;
		}).collect(Collectors.toList());
	}
	
	private TableVariable getTableVariable(TableInfo tableInfo, List<TableQueryInfo> tableQrys) {
		TableVariable result = new TableVariable(new NameVariable((tableInfo.getName()).toLowerCase()));
		result.setSchema(new NameVariable(tableInfo.getSchema()));
		result.setColumns(getColumnVariables(tableInfo.getColumns()));
		result.setEntity(new NameVariable(
				tableQrys
				.stream()
				.filter(tq -> tq.getTable().toLowerCase()
						.equals(tableInfo.getName().toLowerCase()))
						.findFirst()
						.get()
						.getEntity()));
    	return result;
    }
	
	private List<ColumnVariable> getColumnVariables(List<ColumnInfo> columns) {
		if (CollectionUtils.isEmpty(columns)) {
			return Collections.emptyList();
		}
		
		return columns.stream().map(c -> {
			ColumnVariable columnVariable = new ColumnVariable(new NameVariable(c.getName()));
			columnVariable.setKey(c.isKey());
			columnVariable.setType(c.getType());
			columnVariable.setDefaultValue(c.getDefaultValue());
			columnVariable.setLength(c.getLength());
			columnVariable.setNullable(c.isNullable());
			columnVariable.setScale(c.getScale());
			columnVariable.setComment(c.getComment());
			
			return columnVariable;
		}).collect(Collectors.toList());
	}
}
