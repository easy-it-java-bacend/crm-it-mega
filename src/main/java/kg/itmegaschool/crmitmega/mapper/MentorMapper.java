package kg.itmegaschool.crmitmega.mapper;

import kg.itmegaschool.crmitmega.model.dto.MentorDto;
import kg.itmegaschool.crmitmega.model.entity.Mentor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MentorMapper extends BaseMapper<Mentor, MentorDto> {
    MentorMapper INSTANCE = Mappers.getMapper(MentorMapper.class);
}
