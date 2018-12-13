package test.boot;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.boot.core.DataSourceAnalysis;
import test.boot.core.DataSourceCodeGenerator;
import test.boot.core.SimpleCodeGenerator;
import test.boot.core.TableQueryInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TTest {
	
	@Resource
	private DataSource middevDataSource;
	
	@Resource
	private DataSource dcDataSource;
	
	@Resource
	private DataSource uf20DataSource;
	
	@Test
	public void midTest() throws Exception {
		DataSourceCodeGenerator codeGenerator = new DataSourceCodeGenerator(middevDataSource, "mid");
		codeGenerator.addTable("middev", "T_CLIENT_ACC_INFO_ABNORMAL", "ClientAccInfoAbnormal");
		
		Map<String, Object> binding = new HashMap<>();
		binding.put("db", "middev");
		
		codeGenerator.generate(binding);
	}
	
	@Test
	public void dcTest() throws Exception {
		DataSourceCodeGenerator codeGenerator = new DataSourceCodeGenerator(dcDataSource, "mid");
		codeGenerator.addTable("dcraw", "MONITOR_EXECUTE_INFO", "MonitorExecuteInfo");
		
		Map<String, Object> binding = new HashMap<>();
		binding.put("db", "dcoracle");
		
		//TableColumnRetriever
		///oracle.information_schema/SERVER_INFORMATION.sql
		///oracle.information_schema/CONSTRAINT_COLUMN_USAGE.sql
		//ForeignKeyRetriever
		
		codeGenerator.generate(binding);
	}
	
	@Test
	public void uf20Test() throws Exception {
		DataSourceCodeGenerator codeGenerator = new DataSourceCodeGenerator(uf20DataSource, "");
		codeGenerator.addTable("hs_prod", "bankmentrust", "ABC");
		codeGenerator.generate();
	}
	
	@Test
	public void addFileTest() throws Exception {
		SimpleCodeGenerator codeGenerator = new SimpleCodeGenerator("mid-c");
		DataSourceAnalysis dataSourceAnalysis = new DataSourceAnalysis();
		
		//codeGenerator.addTemplateFile("test/demo.java", "keke");
		
		Map<String, Object> binding = new HashMap<>();
		binding.put("t", dataSourceAnalysis.datasoucreAnalyse(middevDataSource, 
				new TableQueryInfo("middev", "T_GGT_HK_YWHB", "GgtHkYwhb")));
		binding.put("db", "mysql");
		binding.put("remark", "业务回报");
		binding.put("unit", "Months");
		binding.put("column", "oc_date");
		
		codeGenerator.generate(binding);
	}
}
