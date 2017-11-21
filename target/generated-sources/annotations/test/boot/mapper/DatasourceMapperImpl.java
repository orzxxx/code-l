package test.boot.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import test.boot.entity.tables.records.TDatasourceRecord;
import test.boot.model.dto.DatasourceDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-11-21T09:40:22+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DatasourceMapperImpl implements DatasourceMapper {

    @Override
    public TDatasourceRecord toEntity(DatasourceDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TDatasourceRecord tDatasourceRecord = new TDatasourceRecord();

        tDatasourceRecord.setId( dto.getId() );
        tDatasourceRecord.setUrl( dto.getUrl() );
        tDatasourceRecord.setUsername( dto.getUsername() );
        tDatasourceRecord.setPassword( dto.getPassword() );
        tDatasourceRecord.setName( dto.getName() );

        return tDatasourceRecord;
    }
}
