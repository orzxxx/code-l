package test.boot.service.impl;

import groovy.lang.Writable;
import groovy.text.GStringTemplateEngine;

import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.jooq.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.common.exception.BusinessException;
import test.boot.dao.DatasourceDao;
import test.boot.dto.TemplateDTO;
import test.boot.model.table.ColumnInfo;
import test.boot.model.table.ColumnVariable;
import test.boot.model.table.NameVariable;
import test.boot.model.table.TableInfo;
import test.boot.model.table.TableVariable;
import test.boot.service.GeneratorService;

@Service
@Transactional
public class GeneratorServiceImpl implements GeneratorService {
	
	@Autowired
	private DatasourceDao datasourceDao;

	@Override
	public String generate(TableInfo tableInfo, TemplateDTO templateDTO, 
			Map<String, Object> params, boolean isGenerated) {
		GStringTemplateEngine engine = new GStringTemplateEngine();
		
		Map<String, Object> binding = new HashMap<>();
		binding.put("t", getTableVariable(tableInfo));
		binding.put("d", new Date());
		binding.put("p", templateDTO.getFilePath());
		binding.putAll(params);
		
		String content = templateDTO.getContent();
		
		try {
			groovy.text.Template template = engine.createTemplate(content);
			Writable w = template.make(binding);
			String fileContent = w.toString();
			if (isGenerated) {
				FileUtils.writeStringToFile(
						new File(getGeneratedFilePath("./template", templateDTO.getFilePath(), 
								getGeneratedFileName(templateDTO.getFileName(), binding))), fileContent, "UTF-8");
			}
			return fileContent;
		} catch (Exception e) {
			throw new BusinessException("生成失败:" + e.getMessage());
		}
		
	}

	private String getGeneratedFileName(String fileName, Map<String, Object> binding) throws Exception {
		GStringTemplateEngine engine = new GStringTemplateEngine();
		groovy.text.Template template = engine.createTemplate(fileName);
		Writable w = template.make(binding);
		return w.toString();
	}
	
	private String getGeneratedFilePath(String localPath, String filePath, String fileName) {
		if (localPath.endsWith("/")) {
			localPath = localPath.substring(0, localPath.length() - 1);
		}
		
		if (StringUtils.isEmpty(filePath)) {
			return localPath + "/" + fileName;
		} else {
			return localPath + "/" + filePath.replace(".", "/") + "/" + fileName;
		}
	}
	
	private TableVariable getTableVariable(TableInfo tableInfo) {
		TableVariable result = new TableVariable(new NameVariable(tableInfo.getName()));
		result.setColumns(getColumnVariables(tableInfo.getColumns()));
    	return result;
    }

	private List<ColumnVariable> getColumnVariables(List<ColumnInfo> columns) {
		if (CollectionUtils.isEmpty(columns)) {
			return Collections.emptyList();
		}
		
		return columns.stream().map(c -> {
			ColumnVariable columnVariable = new ColumnVariable(new NameVariable(c.getName()));
			columnVariable.setKey(c.isKey());
			columnVariable.setType(c.getType());
			columnVariable.setDefaultValue(c.getDefaultValue());
			columnVariable.setLength(c.getLength());
			columnVariable.setNullable(c.isNullable());
			columnVariable.setScale(c.getScale());
			columnVariable.setComment(c.getComment());
			
			return columnVariable;
		}).collect(Collectors.toList());
	}
	
}
