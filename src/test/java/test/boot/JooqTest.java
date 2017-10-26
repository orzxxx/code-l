package test.boot;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import test.boot.dao.TProdInfoDao;
import test.boot.entry.mysql.tables.records.TProdInfoRecord;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JooqTest {
	
	@Autowired
	private TProdInfoDao tProdInfoDao;
	
	@Test
	public void saveTest() {
		TProdInfoRecord record = new TProdInfoRecord("5", new Timestamp(new Date().getTime()));
		tProdInfoDao.save(record);
	}
}
