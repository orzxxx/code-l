package test.boot;

import org.junit.Test;

import cn.com.xyzq.schema.financeproductservicedc._1_0.PublishInformationServiceInType;
import cn.com.xyzq.schema.financeproductservicedc._1_0.PublishProdAllocationInfoInType;
import test.boot.custom.ClassAnalysis;

public class CustomTest {
	
	@Test
	public void class1() throws Exception {
		// FinanceProductServiceDC
		// ClientAccountService
		System.out.println(ClassAnalysis.toXyXml(PublishProdAllocationInfoInType.class, "FinanceProductServiceDC"));
		//System.out.println(ClassAnalysis.toXyXml(PublishInformationServiceInType.class, "FinanceProductServiceDC"));
	}
	
}
