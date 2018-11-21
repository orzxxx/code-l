package test.boot.core.table;

public class ColumnVariable {
	
	public boolean isKey;

	public NameVariable name;

	public String type;

	public int length;

	public int scale;

	public boolean nullable;

	public Object defaultValue;

	public String comment;
	
	// TODO datatype补全
	public boolean isString() {
		return type.equals("VARCHAR2") || type.equals("VARCHAR");
	}
	
	public boolean isInteger() {
		return (type.equals("NUMBER") && scale == 0) || type.equals("INTEGER");
	}
	
	public boolean isBigDecimal() {
		return (type.equals("NUMBER") && scale != 0) || type.equals("DECIMAL");
	}
	
	public boolean isDate() {
		return type.equals("TIME") || type.contains("DATE");
	}
	
	public boolean isBoolean() {
		return type.equals("TINYINT") && length == 1;
	}
	
	public boolean isByte() {
		return type.equals("TINYINT") && length > 1;
	}
	
	public ColumnVariable(NameVariable name) {
		this.name = name;
	}

	public boolean isKey() {
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}

	public NameVariable getName() {
		return name;
	}

	public void setName(NameVariable name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.toUpperCase();
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
