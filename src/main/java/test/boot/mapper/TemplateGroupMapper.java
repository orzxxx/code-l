package test.boot.mapper;

import org.mapstruct.Mapper;

import test.boot.dto.TemplateGroupDTO;
import test.boot.entity.tables.records.TemplateGroupRecord;

@Mapper(componentModel = "spring")
public interface TemplateGroupMapper {

    TemplateGroupRecord toEntity(TemplateGroupDTO dto);
}