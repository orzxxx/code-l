package test.boot.dto;

import java.util.Map;

import test.boot.model.table.TableInfo;

public class GeneratorDTO {

    private TableInfo table;
    
    private TemplateDTO template;
    
    private Map<String, Object> params;
    
    private boolean generated;
    
	public boolean isGenerated() {
		return generated;
	}

	public void setGenerated(boolean generated) {
		this.generated = generated;
	}

	public TableInfo getTable() {
		return table;
	}

	public void setTable(TableInfo table) {
		this.table = table;
	}

	public TemplateDTO getTemplate() {
		return template;
	}

	public void setTemplate(TemplateDTO template) {
		this.template = template;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
    
}
