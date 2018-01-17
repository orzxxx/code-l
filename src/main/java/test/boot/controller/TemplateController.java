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

import test.boot.dto.TemplateDTO;
import test.boot.service.TemplateService;

@RestController
@RequestMapping("/templates")
public class TemplateController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<TemplateDTO> list() {
        return templateService.listTemplate();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TemplateDTO get(@PathVariable int id) {
		return templateService.getTemplate(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int save(@RequestBody TemplateDTO dto) {
		return templateService.saveTemplate(dto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public int update(@RequestBody TemplateDTO dto) {
		return templateService.updateTemplate(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int remove(@PathVariable int id) {
		return templateService.removeTemplate(id);
	}
}
