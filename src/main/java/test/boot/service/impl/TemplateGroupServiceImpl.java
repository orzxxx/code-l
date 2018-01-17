package test.boot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.boot.common.exception.BusinessException;
import test.boot.dao.TemplateGroupDao;
import test.boot.dao.TemplateGroupTemplateDao;
import test.boot.dto.TemplateGroupDTO;
import test.boot.entity.tables.pojos.TemplateGroup;
import test.boot.entity.tables.records.TemplateGroupRecord;
import test.boot.entity.tables.records.TemplateGroupTemplateRecord;
import test.boot.service.TemplateGroupService;

@Service
@Transactional
public class TemplateGroupServiceImpl implements TemplateGroupService {
	
	@Autowired
	private TemplateGroupDao templateGroupDao;
	
	@Autowired
	private TemplateGroupTemplateDao templateGroupTemplateDao;
	
	@Override
	public List<TemplateGroupDTO> listTemplateGroup() {
		return templateGroupDao.list().stream().map(tg -> {
			TemplateGroupDTO dto = new TemplateGroupDTO();
			dto.setId(tg.getId());
			dto.setName(tg.getName());
			dto.settIds(listTemplateId(tg.getId()));
			
			return dto;
		}).collect(Collectors.toList());
	}

	private List<Integer> listTemplateId(Integer tgId) {
		return templateGroupTemplateDao.listByTemplageGroupId(tgId)
				.stream().map(r -> r.getTId())
				.collect(Collectors.toList());
	}

	@Override
	public int saveTemplateGroup(TemplateGroupDTO dto) {
		TemplateGroupRecord record = new TemplateGroupRecord();
		record.setName(dto.getName());
		if (templateGroupDao.countByName(record.getId(), record.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		
		int templateGroupId = templateGroupDao.save(record);
		
		return saveTemplateGroupTemplage(templateGroupId, dto.gettIds());
	}

	private int saveTemplateGroupTemplage(int tgId, List<Integer> tIds) {
		List<TemplateGroupTemplateRecord> records = tIds.stream().map(tId -> {
			TemplateGroupTemplateRecord r = new TemplateGroupTemplateRecord();
			r.setTId(tId);
			r.setTgId(tgId);
			
			return r;
		}).collect(Collectors.toList());
		
		return templateGroupTemplateDao.save(records);
	}

	@Override
	public int updateTemplateGroup(TemplateGroupDTO dto) {
		TemplateGroupRecord record = new TemplateGroupRecord();
		record.setId(dto.getId());
		record.setName(dto.getName());
		if (templateGroupDao.countByName(record.getId(), record.getName()) > 0) {
			throw new BusinessException("名称已存在");
		}
		
		templateGroupDao.update(record);
		templateGroupTemplateDao.removeByTemplateGroupId(dto.getId());
		return saveTemplateGroupTemplage(dto.getId(), dto.gettIds());
	}

	@Override
	public int removeTemplateGroup(int id) {
		return templateGroupDao.remove(id);
	}

	@Override
	public TemplateGroupDTO getTemplateGroup(int id) {
		TemplateGroupDTO result = new TemplateGroupDTO(); 
		TemplateGroup record = templateGroupDao.get(id);
		result.setId(id);
		result.setName(record.getName());
		result.settIds(listTemplateId(result.getId()));
		
		return result;
	}
}
