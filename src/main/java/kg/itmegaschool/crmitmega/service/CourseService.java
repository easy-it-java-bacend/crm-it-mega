package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.dto.CourseDto;
import kg.itmegaschool.crmitmega.model.request.CourseCreateRequest;
import kg.itmegaschool.crmitmega.model.request.GetCourseByCostRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface CourseService {

    CourseDto create(CourseCreateRequest request);

    CourseDto find(Long id);

    CourseDto update(CourseDto courseDto);

    void delete(Long id);

    List<String> findAllCourseNames();

    List<CourseDto> findCoursesByMonthlyCostBetween(GetCourseByCostRequest request);
}
