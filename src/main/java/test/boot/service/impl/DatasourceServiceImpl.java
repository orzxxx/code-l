package test.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.dao.DatasourceDao;
import test.boot.service.DatasourceService;

@Service
@Transactional
public class DatasourceServiceImpl implements DatasourceService {
	
	@Autowired
	private DatasourceDao datasourceDao;
	
	public String listDatasource() {
		return "f1";
	}
	
	public String f2() {
		return "f2";
	}
}
