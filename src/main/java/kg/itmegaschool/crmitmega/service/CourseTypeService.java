package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.MessageResponse;
import kg.itmegaschool.crmitmega.model.dto.CourseTypeDto;
import kg.itmegaschool.crmitmega.model.request.CreateCourseTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseTypeService {

    CourseTypeDto create(CreateCourseTypeRequest request);

    CourseTypeDto find(Long id);

    List<CourseTypeDto> findAll();

    MessageResponse delete(Long id);
}
