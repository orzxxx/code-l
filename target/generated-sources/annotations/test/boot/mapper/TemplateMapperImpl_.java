package test.boot.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import test.boot.dto.TemplateDTO;
import test.boot.entity.tables.pojos.Template;
import test.boot.entity.tables.records.TemplateRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-17T09:53:11+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class TemplateMapperImpl_ implements TemplateMapper {

    @Override
    public TemplateRecord toEntity(TemplateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TemplateRecord templateRecord = new TemplateRecord();

        templateRecord.setId( dto.getId() );
        templateRecord.setContent( dto.getContent() );
        templateRecord.setName( dto.getName() );
        templateRecord.setFileName( dto.getFileName() );
        templateRecord.setFilePath( dto.getFilePath() );

        return templateRecord;
    }

    @Override
    public TemplateDTO toDTO(Template entity) {
        if ( entity == null ) {
            return null;
        }

        TemplateDTO templateDTO = new TemplateDTO();

        templateDTO.setId( entity.getId() );
        templateDTO.setContent( entity.getContent() );
        templateDTO.setName( entity.getName() );
        templateDTO.setFileName( entity.getFileName() );
        templateDTO.setFilePath( entity.getFilePath() );

        return templateDTO;
    }

    @Override
    public List<TemplateDTO> toDTO(List<Template> list) {
        if ( list == null ) {
            return null;
        }

        List<TemplateDTO> list1 = new ArrayList<TemplateDTO>( list.size() );
        for ( Template template : list ) {
            list1.add( toDTO( template ) );
        }

        return list1;
    }
}
