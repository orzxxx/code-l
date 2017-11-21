/*package test.boot.service.impl;

import static test.boot.entry.mysql.tables.TProdInfo.T_PROD_INFO;

import java.sql.Timestamp;
import java.util.Date;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.entry.mysql.tables.records.TProdInfoRecord;

@Service
@Transactional
public class ProdInfoServiceImpl {
	@Autowired
	private DSLContext create;
	
	public void transaction() {
		TProdInfoRecord r1 = new TProdInfoRecord("1", new Timestamp(new Date().getTime()));
		TProdInfoRecord r2 = new TProdInfoRecord("2", new Timestamp(new Date().getTime()));
		
		create.update(T_PROD_INFO)
		.set(r1)
		.where(T_PROD_INFO.PROD_CODE.eq(r1.getProdCode()))
		.execute();
		
		if (true) {
			int a = 1 / 0;
		} 
		
		create.update(T_PROD_INFO)
		.set(r2)
		.where(T_PROD_INFO.PROD_CODE.eq(r2.getProdCode()))
		.execute();
	}
}
*/