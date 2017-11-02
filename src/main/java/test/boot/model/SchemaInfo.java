package test.boot.model;

import java.util.List;

public class SchemaInfo {
	
	private String name;
	
	private List<TableInfo> tableInfos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TableInfo> getTableInfos() {
		return tableInfos;
	}

	public void setTableInfos(List<TableInfo> tableInfos) {
		this.tableInfos = tableInfos;
	}
}
