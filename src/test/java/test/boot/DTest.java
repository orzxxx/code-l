package test.boot;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.boot.core.DataSourceCodeGenerator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DTest {
	
	@Resource
	private DataSource middevDataSource;
	
	@Resource
	private DataSource dcDataSource;
	
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
		DataSourceCodeGenerator codeGenerator = new DataSourceCodeGenerator(dcDataSource, "");
		codeGenerator.addTable("dcraw", "MONITOR_EXECUTE_INFO", "MonitorExecuteInfo");
		codeGenerator.generate();
	}
}
