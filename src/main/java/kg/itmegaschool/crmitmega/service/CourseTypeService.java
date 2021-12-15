package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.MessageResponse;
import kg.itmegaschool.crmitmega.model.dto.CourseTypeDto;
import kg.itmegaschool.crmitmega.model.request.CreateCourseTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseTypeService {

    CourseTypeDto create(CreateCourseTypeRequest request);

    CourseTypeDto read(Long id);

    List<CourseTypeDto> readAll();

    MessageResponse delete(Long id);
}
