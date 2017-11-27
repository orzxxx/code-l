package test.boot.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;
import test.boot.mapper.decorator.TemplateMapperDecorator;
import test.boot.model.dto.TemplateDTO;

@Mapper(componentModel = "spring")
@DecoratedWith(TemplateMapperDecorator.class)
public interface TemplateMapper {

	@Mapping(target="tags", ignore=true)
    TemplateRecord toEntity(TemplateDTO dto);
	
	@Mapping(target="tags", ignore=true)
	TemplateDTO toDTO(Template entity);
}
