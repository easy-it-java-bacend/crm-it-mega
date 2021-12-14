package kg.itmegaschool.crmitmega.mapper;

import kg.itmegaschool.crmitmega.model.dto.CourseDto;
import kg.itmegaschool.crmitmega.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper extends BaseMapper<Course, CourseDto> {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
}
