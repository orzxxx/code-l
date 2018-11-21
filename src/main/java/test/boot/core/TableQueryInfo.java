package test.boot.core;

class TableQueryInfo {

	private String schema;
	
	private String table;
	
	private String entity;
	
	public TableQueryInfo(String schema, String table, String entity) {
		super();
		this.schema = schema;
		this.table = table;
		this.entity = entity;
	}

	public String getSchema() {
		return schema;
	}

	public String getTable() {
		return table;
	}

	public String getEntity() {
		return entity;
	}
}
