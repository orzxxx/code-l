package test.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.common.exception.BusinessException;
import test.boot.dao.DatasourceDao;
import test.boot.entity.tables.pojos.TDatasource;
import test.boot.entity.tables.records.TDatasourceRecord;
import test.boot.service.DatasourceService;

@Service
@Transactional
public class DatasourceServiceImpl implements DatasourceService {
	
	@Autowired
	private DatasourceDao datasourceDao;
	
	@Override
	public List<TDatasource> listDatasource() {
		return datasourceDao.list();
	}

	@Override
	public int saveDatasource(TDatasourceRecord record) {
		if (datasourceDao.countByName(record.getId(), record.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return datasourceDao.save(record);
	}

	@Override
	public int updateDatasource(TDatasourceRecord record) {
		if (datasourceDao.countByName(record.getId(), record.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return datasourceDao.update(record);
	}

	@Override
	public int removeDatasource(int id) {
		return datasourceDao.delete(id);
	}

	@Override
	public TDatasource getDatasource(int id) {
		return datasourceDao.get(id);
	}
}
