package kg.itmegaschool.crmitmega.mapper;

import kg.itmegaschool.crmitmega.model.dto.StudentDto;
import kg.itmegaschool.crmitmega.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper extends BaseMapper<Student, StudentDto> {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
}
