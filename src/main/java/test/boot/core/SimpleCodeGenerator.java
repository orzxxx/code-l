package test.boot.core;

import java.util.List;
import java.util.Map;

public class SimpleCodeGenerator extends AbstractCodeGenerator {
	
	public SimpleCodeGenerator(String module) {
		this(module, "");
	}
	
	public SimpleCodeGenerator(String module, String outputPath) {
		super(module, outputPath);
	}
	
	public void generate(Map<String, Object> params) {
		List<TemplateFile> templateFiles = getTemplateFiles();
		templateFiles.forEach(tf -> {
			System.out.println("==============" + tf.getPath());
			generate(tf, getBinding(tf, params));
		});
	}
}
