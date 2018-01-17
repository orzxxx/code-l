package test.boot.mapper.decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import test.boot.dto.TemplateDTO;
import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;
import test.boot.mapper.TemplateMapper;

public abstract class TemplateMapperDecorator implements TemplateMapper {
	
	@Autowired
    @Qualifier("delegate")
    private TemplateMapper delegate;
	
	@Override
	public TemplateRecord toEntity(TemplateDTO dto) {
		TemplateRecord result = delegate.toEntity(dto);
		List<String> parameters = dto.getParameters();
		if (CollectionUtils.isNotEmpty(parameters)) {
			result.setParameters(String.join(",", parameters));
		}
		
		return result;
	}
	
	@Override
	public TemplateDTO toDTO(Template entity) {
		TemplateDTO result = delegate.toDTO(entity);
		String parameters = entity.getParameters();
		if (StringUtils.isNotEmpty(parameters)) {
			result.setParameters(Arrays.asList(parameters.split(",")));
		}
		
		return result;
	}

	@Override
	public List<TemplateDTO> toDTO(List<Template> entities) {
		List<TemplateDTO> result = new ArrayList<>();
		for (Template entity : entities) {
			result.add(toDTO(entity));
		}
		return result;
	}
}
