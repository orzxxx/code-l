package test.boot.service;

import java.util.List;

import test.boot.dto.TemplateGroupDTO;

public interface TemplateGroupService {

	List<TemplateGroupDTO> listTemplateGroup();

	int saveTemplateGroup(TemplateGroupDTO dto);

	int updateTemplateGroup(TemplateGroupDTO record);

	int removeTemplateGroup(int id);

	TemplateGroupDTO getTemplateGroup(int id);

}
