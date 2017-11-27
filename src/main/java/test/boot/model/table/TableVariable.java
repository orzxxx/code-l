package test.boot.model.table;

import java.util.List;

public class TableVariable {
	
	public NameVariable name;

	public List<ColumnVariable> columns;

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

}
