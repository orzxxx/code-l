package test.boot.core;

import groovy.lang.Writable;
import groovy.text.GStringTemplateEngine;
import groovy.text.Template;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import test.boot.core.table.NameVariable;

import com.google.common.base.Strings;

public abstract class AbstractCodeGenerator {
	
	private static final String OUTPUT_PATH = "output/";
	
	private TemplateFileScaner templateFileScaner = new TemplateFileScaner();
	
	private String outputPath;
	
	private String module;
	
	private Map<String, String> srcFilePathToDescFilePath = new HashMap<>();
	
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
	
	public void addTemplateFile(String src, String desc) {
		srcFilePathToDescFilePath.put(src, desc);
	}
	
	protected List<TemplateFile> getTemplateFiles() {
		List<TemplateFile> result = new ArrayList<>();
		srcFilePathToDescFilePath.forEach((v, k) -> {
			File srcFile = new File(templateFileScaner.createFilePath(v));
			// TODO 只能文件夹
			File descFile = new File(templateFileScaner.createFilePath(createFilePath(k)));
			if (!srcFile.exists()) {
				System.out.println("=========srcFile不存在:" + v);
				return;
			}
			
			if (srcFile.isFile()) {
				result.add(templateFileScaner.createTemplateFile(
						srcFile.getName(), srcFile, descFile.getPath() + "\\" + srcFile.getName()));
			} else {
				FileUtils.listFiles(
						new File(v), 
						TrueFileFilter.INSTANCE, 
						TrueFileFilter.INSTANCE)
						.stream()
						.forEach(f -> {
							result.add(templateFileScaner.createTemplateFile(
									f.getName(), f, descFile.getPath() + "\\" + f.getName()));
						});
			} 
		});
		// 
		result.addAll(templateFileScaner.scan(module));
		return result;
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
	
	private String createFilePath(String path) {
		if (path.startsWith("/")) {
			return module + path;
		} else {
			return module + "/" + path;
		}
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
