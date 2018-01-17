package test.boot.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import test.boot.dto.DatasourceDTO;
import test.boot.entity.tables.pojos.Datasource;
import test.boot.entity.tables.records.DatasourceRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-17T09:53:11+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DatasourceMapperImpl implements DatasourceMapper {

    @Override
    public DatasourceRecord toEntity(DatasourceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DatasourceRecord datasourceRecord = new DatasourceRecord();

        datasourceRecord.setId( dto.getId() );
        datasourceRecord.setUrl( dto.getUrl() );
        datasourceRecord.setUsername( dto.getUsername() );
        datasourceRecord.setPassword( dto.getPassword() );
        datasourceRecord.setName( dto.getName() );

        return datasourceRecord;
    }

    @Override
    public DatasourceDTO toDTO(Datasource entity) {
        if ( entity == null ) {
            return null;
        }

        DatasourceDTO datasourceDTO = new DatasourceDTO();

        datasourceDTO.setId( entity.getId() );
        datasourceDTO.setUrl( entity.getUrl() );
        datasourceDTO.setUsername( entity.getUsername() );
        datasourceDTO.setPassword( entity.getPassword() );
        datasourceDTO.setName( entity.getName() );

        return datasourceDTO;
    }

    @Override
    public List<DatasourceDTO> toDTO(List<Datasource> list) {
        if ( list == null ) {
            return null;
        }

        List<DatasourceDTO> list1 = new ArrayList<DatasourceDTO>( list.size() );
        for ( Datasource datasource : list ) {
            list1.add( toDTO( datasource ) );
        }

        return list1;
    }
}
