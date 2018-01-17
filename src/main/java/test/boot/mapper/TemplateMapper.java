package test.boot.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import test.boot.dto.TemplateDTO;
import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;
import test.boot.mapper.decorator.TemplateMapperDecorator;

@Mapper(componentModel = "spring")
@DecoratedWith(TemplateMapperDecorator.class)
public interface TemplateMapper {

	@Mapping(target="parameters", ignore=true)
    TemplateRecord toEntity(TemplateDTO dto);
	
	@Mapping(target="parameters", ignore=true)
	TemplateDTO toDTO(Template entity);

	List<TemplateDTO> toDTO(List<Template> list);
}
