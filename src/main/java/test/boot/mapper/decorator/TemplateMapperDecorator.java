package test.boot.mapper.decorator;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;
import test.boot.mapper.TemplateMapper;
import test.boot.model.dto.TemplateDTO;

public abstract class TemplateMapperDecorator implements TemplateMapper {
	
	@Autowired
    @Qualifier("delegate")
    private TemplateMapper delegate;
	
	@Override
	public TemplateRecord toEntity(TemplateDTO dto) {
		TemplateRecord result = delegate.toEntity(dto);
		List<String> tags = dto.getTags();
		if (CollectionUtils.isNotEmpty(tags)) {
			result.setTags(String.join(",", tags));
		}
		
		return result;
	}
	
	@Override
	public TemplateDTO toDTO(Template entity) {
		TemplateDTO result = delegate.toDTO(entity);
		String tags = entity.getTags();
		if (StringUtils.isNotEmpty(tags)) {
			result.setTags(Arrays.asList(tags.split(",")));
		}
		
		return result;
	}

}
