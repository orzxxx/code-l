package test.boot.mapper;

import javax.annotation.Generated;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import test.boot.mapper.decorator.TemplateMapperDecorator;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-01-17T09:53:11+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
@Primary
public class TemplateMapperImpl extends TemplateMapperDecorator implements TemplateMapper {
}
