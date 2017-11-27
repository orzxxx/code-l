package test.boot.mapper;

import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import test.boot.entity.tables.pojos.TTemplate;
import test.boot.entity.tables.records.TTemplateRecord;
import test.boot.model.dto.TTemplateDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-11-27T16:01:17+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class TemplateMapperImpl_ implements TemplateMapper {

    @Override
    public TTemplateRecord toEntity(TTemplateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TTemplateRecord tTemplateRecord = new TTemplateRecord();

        tTemplateRecord.setId( dto.getId() );
        tTemplateRecord.setContent( dto.getContent() );
        tTemplateRecord.setName( dto.getName() );
        tTemplateRecord.setFileName( dto.getFileName() );

        return tTemplateRecord;
    }

    @Override
    public TTemplateDTO toDTO(TTemplate entity) {
        if ( entity == null ) {
            return null;
        }

        TTemplateDTO tTemplateDTO = new TTemplateDTO();

        tTemplateDTO.setId( entity.getId() );
        tTemplateDTO.setContent( entity.getContent() );
        tTemplateDTO.setName( entity.getName() );
        tTemplateDTO.setFileName( entity.getFileName() );

        return tTemplateDTO;
    }
}
