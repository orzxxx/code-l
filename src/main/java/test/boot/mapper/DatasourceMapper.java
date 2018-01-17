package test.boot.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import test.boot.dto.DatasourceDTO;
import test.boot.entity.tables.pojos.Datasource;
import test.boot.entity.tables.records.DatasourceRecord;

@Mapper(componentModel = "spring")
public interface DatasourceMapper {

    DatasourceRecord toEntity(DatasourceDTO dto);
    
    DatasourceDTO toDTO(Datasource entity);

	List<DatasourceDTO> toDTO(List<Datasource> list);
}
