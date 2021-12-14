package kg.itmegaschool.crmitmega.mapper;

import kg.itmegaschool.crmitmega.model.dto.CourseTypeDto;
import kg.itmegaschool.crmitmega.model.entity.CourseType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseTypeMapper extends BaseMapper<CourseType, CourseTypeDto> {
    CourseTypeMapper INSTANCE = Mappers.getMapper(CourseTypeMapper.class);
}