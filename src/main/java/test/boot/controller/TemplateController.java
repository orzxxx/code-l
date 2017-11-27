package test.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.boot.entity.tables.pojos.Template;
import test.boot.mapper.TemplateMapper;
import test.boot.model.dto.TemplateDTO;
import test.boot.service.TemplateService;

@RestController
@RequestMapping("/templates")
public class TemplateController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private TemplateMapper templateMapper;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<Template> list() {
        return templateService.listTemplate();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TemplateDTO get(@PathVariable int id) {
		return templateMapper.toDTO(templateService.getTemplate(id));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int save(@RequestBody TemplateDTO dto) {
		return templateService.saveTemplate(templateMapper.toEntity(dto));
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public int update(@RequestBody TemplateDTO dto) {
		return templateService.updateTemplate(templateMapper.toEntity(dto));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int remove(@PathVariable int id) {
		return templateService.removeTemplate(id);
	}
}
