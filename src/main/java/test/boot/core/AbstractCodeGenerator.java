package test.boot.core;

import groovy.lang.Writable;
import groovy.text.GStringTemplateEngine;
import groovy.text.Template;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import test.boot.core.table.NameVariable;

import com.google.common.base.Strings;

public abstract class AbstractCodeGenerator {
	
	private static final String OUTPUT_PATH = "output/";
	
	private TemplateFileScaner templateFileScaner = new TemplateFileScaner();
	
	private String outputPath;
	
	private String module;
	
	public AbstractCodeGenerator(String module, String outputPath) {
		super();
		this.module = module;
		this.outputPath = outputPath;
	}
	
	public void generate() {
		generate(new HashMap<String, Object>());
	}
	
	protected void generate(TemplateFile templateFile, 
			Map<String, Object> binding) {
		GStringTemplateEngine engine = new GStringTemplateEngine();
		String content = templateFile.getContent();
		
		try {
			Template template = engine.createTemplate(content);
			Writable w = template.make(binding);
			String fileContent = w.toString();
			FileUtils.writeStringToFile(
					new File(getOutputPath() + 
							getGeneratedFilePath(templateFile.getPath().trim(), binding)), 
							fileContent, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("生成失败:" + e.getMessage());
		}
	}
	
	protected List<TemplateFile> getTemplateFiles() {
		return templateFileScaner.scan(module);
	}
	
	protected Map<String, Object> getBinding(TemplateFile templateFile, Map<String, Object> params) {
		Map<String, Object> result = new HashMap<>();
		result.put("date", new Date()); 
		result.put("path", templateFile.getPath().trim());
		params.forEach((k, v) -> {
			if (v instanceof String) {
				result.put(k, new NameVariable((String )v));
			} else {
				result.put(k, v);
			}
		});
		return result;
	}
	
	protected String getOutputPath() {
		if (Strings.isNullOrEmpty(outputPath)) {
			return OUTPUT_PATH;
		}
		
		if (outputPath.endsWith("/")) {
			return outputPath;
		} else {
			return outputPath + "/";
		}
	}

	protected String getGeneratedFilePath(String filePath, Map<String, Object> binding) throws Exception {
		GStringTemplateEngine engine = new GStringTemplateEngine();
		Template template = engine.createTemplate(filePath.replaceAll("\\\\", "\\\\\\\\").toString());
		Writable w = template.make(binding);
		return w.toString();
	}
	
	public abstract void generate(Map<String, Object> params);
}
