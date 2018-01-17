package test.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.boot.dto.GeneratorDTO;
import test.boot.model.table.ColumnInfo;
import test.boot.model.table.TableInfo;
import test.boot.service.GeneratorService;

@Controller
@RequestMapping("/generator")
public class GeneratorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private GeneratorService generatorService;
	
	/*@RequestMapping(value = "review", method = RequestMethod.POST)
	String generate(@RequestBody TableInfo table, @RequestBody TemplateDTO template, 
			@RequestBody Map<String, Object> params) throws Exception {
		return generatorService.generate(table, template, params);
    }*/
	
	@RequestMapping(value = "review", method = RequestMethod.POST)
	@ResponseBody
	public String generate(@RequestBody GeneratorDTO generatorDTO) throws Exception {
		return generatorService.generate(generatorDTO.getTable(), 
				generatorDTO.getTemplate(), generatorDTO.getParams(), generatorDTO.isGenerated());
	}
	
	@RequestMapping(value = "test", method = RequestMethod.POST)
	@ResponseBody
	public String generateTest(@RequestBody GeneratorDTO generatorDTO) throws Exception {
		TableInfo demoTable = new TableInfo();
		demoTable.setName("demo_table");
		demoTable.setColumns(buildDemoColumns());
		
		return generatorService.generate(demoTable, 
				generatorDTO.getTemplate(), generatorDTO.getParams(), false);
	}

	private List<ColumnInfo> buildDemoColumns() {
		List<ColumnInfo> result = new ArrayList<>();
		result.add(buildVarcharColumn());
		result.add(buildIntColumn());
		result.add(builddDcimalColumn());
		return result;
	}

	private ColumnInfo buildVarcharColumn() {
		ColumnInfo result = new ColumnInfo();
		result.setName("demo_column_varchar");
		result.setDefaultValue("default_varchar");
		result.setLength(255);
		result.setType("varchar");
		result.setComment("commnet_varchar");
		return result;
	}
	
	private ColumnInfo buildIntColumn() {
		ColumnInfo result = new ColumnInfo();
		result.setName("demo_column_int_key");
		result.setDefaultValue("default_int");
		result.setLength(255);
		result.setType("int");
		result.setComment("commnet_int");
		result.setKey(true);
		return result;
	}
	
	private ColumnInfo builddDcimalColumn() {
		ColumnInfo result = new ColumnInfo();
		result.setName("demo_column_decimal");
		result.setDefaultValue("default_decimal");
		result.setLength(5);
		result.setType("decimal");
		result.setComment("commnet_decimal");
		result.setScale(4);
		return result;
	}
}
