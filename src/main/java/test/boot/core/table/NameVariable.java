package test.boot.core.table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class NameVariable {
	
	private String value;
	
	public NameVariable(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public String pascalCase() {
		String result = value;
		return StringUtils.remove(WordUtils.capitalizeFully(result, '_'), "_");
	}
	
	public String camelCase() {
		String result = pascalCase();
		return result.substring(0, 1).toLowerCase() + result.substring(1);
	}
	
	public String toLowerCase() {
		return value.toLowerCase();
	}
	
	public String toUpperCase() {
		return value.toUpperCase();
	}
	
	public String plus(String str) {
		return value + str;
	}

	public boolean equals(String str) {
		return value.equals(str);
	}
}
