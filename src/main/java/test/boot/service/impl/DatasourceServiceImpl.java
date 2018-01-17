package test.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.common.exception.BusinessException;
import test.boot.dao.DatasourceDao;
import test.boot.dto.DatasourceDTO;
import test.boot.mapper.DatasourceMapper;
import test.boot.service.DatasourceService;

@Service
@Transactional
public class DatasourceServiceImpl implements DatasourceService {
	
	@Autowired
	private DatasourceDao datasourceDao;
	
	@Autowired
	private DatasourceMapper datasourceMapper;
	
	@Override
	public List<DatasourceDTO> listDatasource() {
		return datasourceMapper.toDTO(datasourceDao.list());
	}

	@Override
	public int saveDatasource(DatasourceDTO dto) {
		if (datasourceDao.countByName(dto.getId(), dto.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return datasourceDao.save(datasourceMapper.toEntity(dto));
	}

	@Override
	public int updateDatasource(DatasourceDTO dto) {
		if (datasourceDao.countByName(dto.getId(), dto.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return datasourceDao.update(datasourceMapper.toEntity(dto));
	}

	@Override
	public int removeDatasource(int id) {
		return datasourceDao.remove(id);
	}

	@Override
	public DatasourceDTO getDatasource(int id) {
		return datasourceMapper.toDTO(datasourceDao.get(id));
	}
}
