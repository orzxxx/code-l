package test.boot.mapper;

import org.mapstruct.Mapper;

import test.boot.entity.tables.records.DatasourceRecord;
import test.boot.model.dto.DatasourceDTO;

@Mapper(componentModel = "spring")
public interface DatasourceMapper {

    DatasourceRecord toEntity(DatasourceDTO dto);
}
