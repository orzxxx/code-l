package test.boot.model.table;

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
	
	public String beanName() {
		if (value.startsWith("t_") || value.startsWith("v_") || value.startsWith("r_")) {
			return pascalCase().substring(1);
		} else {
			return pascalCase();
		}
	}
	
	public String camelBeanName() {
		if (value.startsWith("t_") || value.startsWith("v_") || value.startsWith("r_")) {
			String camelCaseName = camelCase();
			return camelCaseName.substring(1, 2).toLowerCase() + camelCaseName.substring(2);
		} else {
			return camelCase();
		}
	}
}
