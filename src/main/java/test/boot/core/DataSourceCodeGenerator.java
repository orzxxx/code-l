package test.boot.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import test.boot.core.table.TableVariable;

public class DataSourceCodeGenerator extends AbstractCodeGenerator {
	
	private DataSourceAnalysis dataSourceAnalysis = new DataSourceAnalysis();
	
	private DataSource datasource;
	
	private List<TableQueryInfo> tableQrys = new ArrayList<>();
	
	public DataSourceCodeGenerator(DataSource datasource, String module) {
		this(datasource, module, "");
	}
	
	public DataSourceCodeGenerator(DataSource datasource, String module, String outputPath) {
		super(module, outputPath);
		this.datasource = datasource;
	}
	
	public void addTable(String schema, String table, String entity) {
		tableQrys.add(new TableQueryInfo(schema, table, entity));
	}
	
	public void generate(Map<String, Object> params) {
		List<TableVariable> tableVals = dataSourceAnalysis.datasoucreAnalyse(datasource, tableQrys);
		List<TemplateFile> templateFiles = getTemplateFiles();
		tableVals.forEach(t -> {
			templateFiles.forEach(tf -> {
				Map<String, Object> binding = getBinding(tf, params);
				binding.put("t", t);
				System.out.println("generating " + tf.getName());
				generate(tf, binding);
			});
		});
		System.out.println("generate end");
	}
}
