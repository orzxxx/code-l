package test.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.common.exception.BusinessException;
import test.boot.dao.TemplateDao;
import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;
import test.boot.service.TemplateService;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {
	
	@Autowired
	private TemplateDao templateDao;
	
	@Override
	public List<Template> listTemplate() {
		return templateDao.list();
	}

	@Override
	public int saveTemplate(TemplateRecord record) {
		if (templateDao.countByName(record.getId(), record.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return templateDao.save(record);
	}

	@Override
	public int updateTemplate(TemplateRecord record) {
		if (templateDao.countByName(record.getId(), record.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		return templateDao.update(record);
	}

	@Override
	public int removeTemplate(int id) {
		return templateDao.delete(id);
	}

	@Override
	public Template getTemplate(int id) {
		return templateDao.get(id);
	}
}
