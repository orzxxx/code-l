package test.boot.core.table;

import java.util.List;

public class TableVariable {
	
	public NameVariable name;
	
	public NameVariable entity;
	
	public NameVariable schema;
	
	public List<ColumnVariable> columns;

	public NameVariable getEntity() {
		return entity;
	}

	public void setEntity(NameVariable entity) {
		this.entity = entity;
	}

	public TableVariable(NameVariable name) {
		super();
		this.name = name;
	}

	public NameVariable getName() {
		return name;
	}

	public void setName(NameVariable name) {
		this.name = name;
	}

	public List<ColumnVariable> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnVariable> columns) {
		this.columns = columns;
	}

	public NameVariable getSchema() {
		return schema;
	}

	public void setSchema(NameVariable schema) {
		this.schema = schema;
	}

}
