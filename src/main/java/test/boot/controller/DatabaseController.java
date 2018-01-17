package test.boot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.boot.model.table.SchemaInfo;
import test.boot.service.DatabaseService;

@RestController
@RequestMapping("/databases")
public class DatabaseController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DatabaseService databaseService;
	
	@RequestMapping(value="/schemas/{dId}", method = RequestMethod.GET)
	List<SchemaInfo> list(@PathVariable int dId) throws Exception {
		return databaseService.listSchemaByDatasourceId(dId);
    }
}
