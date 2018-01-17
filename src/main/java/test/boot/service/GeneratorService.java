package test.boot.service;

import java.util.Map;

import test.boot.dto.TemplateDTO;
import test.boot.model.table.TableInfo;

public interface GeneratorService {

	String generate(TableInfo tableInfo, TemplateDTO templateDTO,
			Map<String, Object> params, boolean isGenerated);

}
