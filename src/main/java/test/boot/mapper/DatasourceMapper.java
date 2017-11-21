package test.boot.mapper;

import org.mapstruct.Mapper;

import test.boot.entity.tables.records.TDatasourceRecord;
import test.boot.model.dto.DatasourceDTO;

@Mapper(componentModel = "spring")
public interface DatasourceMapper {

    TDatasourceRecord toEntity(DatasourceDTO dto);
}
