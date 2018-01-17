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

import test.boot.dto.DatasourceDTO;
import test.boot.service.DatasourceService;

@RestController
@RequestMapping("/datasources")
public class DatasourceController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DatasourceService datasourceService;
	
	@RequestMapping(method = RequestMethod.GET)
    public List<DatasourceDTO> list() {
        return datasourceService.listDatasource();
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DatasourceDTO get(@PathVariable int id) {
		return datasourceService.getDatasource(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public int save(@RequestBody DatasourceDTO dto) {
		return datasourceService.saveDatasource(dto);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public int update(@RequestBody DatasourceDTO dto) {
		return datasourceService.updateDatasource(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public int remove(@PathVariable int id) {
		return datasourceService.removeDatasource(id);
	}
}
