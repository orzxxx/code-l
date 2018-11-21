package test.boot.core.table;

import java.util.List;

import com.google.common.base.Strings;

public class TableInfo {
	
	private String name;
	
	private String schema;
	
	private String entity;

	private List<ColumnInfo> columns;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnInfo> columns) {
		this.columns = columns;
	}
	
	public String getFullName() {
		if (Strings.isNullOrEmpty(schema)) {
			return name.toUpperCase();
		} 
		
		return (schema + "." + name).toUpperCase();
	}
}
