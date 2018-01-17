package test.boot.service;

import java.util.List;

import test.boot.dto.TemplateDTO;

public interface TemplateService {

	List<TemplateDTO> listTemplate();

	int saveTemplate(TemplateDTO record);

	int updateTemplate(TemplateDTO record);

	int removeTemplate(int id);

	TemplateDTO getTemplate(int id);

}
