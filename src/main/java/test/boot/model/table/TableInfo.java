package test.boot.model.table;

import java.util.List;

public class TableInfo {

	private String name;

	private List<ColumnInfo> columns;

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
}
