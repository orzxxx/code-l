package test.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.common.exception.BusinessException;
import test.boot.dao.TemplateDao;
import test.boot.dto.TemplateDTO;
import test.boot.mapper.TemplateMapper;
import test.boot.service.TemplateService;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {
	
	@Autowired
	private TemplateDao templateDao;
	
	@Autowired
	private TemplateMapper templateMapper;
	
	@Override
	public List<TemplateDTO> listTemplate() {
		return templateMapper.toDTO(templateDao.list());
	}

	@Override
	public int saveTemplate(TemplateDTO dto) {
		if (templateDao.countByName(dto.getId(), dto.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return templateDao.save(templateMapper.toEntity(dto));
	}

	@Override
	public int updateTemplate(TemplateDTO dto) {
		if (templateDao.countByName(dto.getId(), dto.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return templateDao.update(templateMapper.toEntity(dto));
	}

	@Override
	public int removeTemplate(int id) {
		return templateDao.remove(id);
	}

	@Override
	public TemplateDTO getTemplate(int id) {
		return templateMapper.toDTO(templateDao.get(id));
	}
}
