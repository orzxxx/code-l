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

import test.boot.dto.TemplateGroupDTO;
import test.boot.service.TemplateGroupService;

@RestController
@RequestMapping("/templateGroups")
public class TemplateGroupController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TemplateGroupService templateGroupService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<TemplateGroupDTO> list() {
        return templateGroupService.listTemplateGroup();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TemplateGroupDTO get(@PathVariable int id) {
		return templateGroupService.getTemplateGroup(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int save(@RequestBody TemplateGroupDTO dto) {
		return templateGroupService.saveTemplateGroup(dto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public int update(@RequestBody TemplateGroupDTO dto) {
		return templateGroupService.updateTemplateGroup(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int remove(@PathVariable int id) {
		return templateGroupService.removeTemplateGroup(id);
	}
	
}