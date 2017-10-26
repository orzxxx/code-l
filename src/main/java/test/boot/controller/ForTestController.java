package test.boot.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.boot.dao.TProdInfoDao;
import test.boot.entry.mysql.tables.records.TProdInfoRecord;
import test.boot.service.impl.ProdInfoServiceImpl;

@RestController
public class ForTestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TProdInfoDao tProdInfoDao;
	
	@Autowired
	private ProdInfoServiceImpl impl;
	
    @RequestMapping("/")
    public String home() {
    	//int i = 4 / 0;
        return "Hello World";
    }
    
    @RequestMapping("/t")
    void t() {
    	impl.transaction();
    }
    
    @RequestMapping("/list")
    Object list() {
    	logger.info("list=======================");
    	return tProdInfoDao.list();
    }
    
    @RequestMapping("/page")
    Object page() {
    	return tProdInfoDao.page(1, 2);
    }
    
    @RequestMapping("/get")
    Object get() {
    	return tProdInfoDao.get("TG0044370");
    }
    
    @RequestMapping("/save")
    Object save() {
    	TProdInfoRecord record = new TProdInfoRecord("1", new Timestamp(new Date().getTime()));
    	return tProdInfoDao.save(record);
    }
    
    @RequestMapping("/batchsave")
    Object batchsave() {
    	TProdInfoRecord record1 = new TProdInfoRecord("2", new Timestamp(new Date().getTime()));
    	TProdInfoRecord record2 = new TProdInfoRecord("3", new Timestamp(new Date().getTime()));
    	List<TProdInfoRecord> records = new ArrayList<TProdInfoRecord>();
    	records.add(record1);
    	records.add(record2);
    	return tProdInfoDao.save(records);
    }
    
    @RequestMapping("/update")
    Object update() {
    	TProdInfoRecord record = new TProdInfoRecord("1", new Timestamp(new Date().getTime()));
    	return tProdInfoDao.update(record);
    }
    
    @RequestMapping("/remove")
    Object remove() {
    	return tProdInfoDao.remove("1");
    }
}
