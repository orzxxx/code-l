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
import test.boot.core.SimpleCodeGenerator;
import test.boot.core.TableQueryInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DTest {
	
	@Resource
	private DataSource middevDataSource;
	
	@Resource
	private DataSource dcDataSource;
	
	@Test
	public void dTest() throws Exception {
		SimpleCodeGenerator codeGenerator = new SimpleCodeGenerator("mid-t");
		DataSourceAnalysis dataSourceAnalysis = new DataSourceAnalysis();
		
		Map<String, Object> binding = new HashMap<>();
		binding.put("t", dataSourceAnalysis.datasoucreAnalyse(middevDataSource, 
				new TableQueryInfo("middev", "T_GGT_SZHK_YWHB", "GgtSzhkYwhb")));
		binding.put("t1", dataSourceAnalysis.datasoucreAnalyse(dcDataSource, 
				new TableQueryInfo("DCSER", "ZD_SZHK_YWHB", "ZdSzhkYwhb")));
		binding.put("db", "mysql");
		binding.put("db1", "dcoracle");
		binding.put("remark", "港股通数据采集");
		binding.put("taskName", "T_GGT_");
		
		codeGenerator.generate(binding);
	}
	
	@Test
	public void cTest() throws Exception {
		SimpleCodeGenerator codeGenerator = new SimpleCodeGenerator("mid-c");
		DataSourceAnalysis dataSourceAnalysis = new DataSourceAnalysis();
		
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
