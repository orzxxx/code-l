package test.boot.service;

import java.util.List;

import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;

public interface TemplateService {

	List<Template> listTemplate();

	int saveTemplate(TemplateRecord record);

	int updateTemplate(TemplateRecord record);

	int removeTemplate(int id);

	Template getTemplate(int id);

}
