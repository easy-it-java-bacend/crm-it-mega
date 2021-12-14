package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.exceptions.CourseNotFoundException;
import kg.itmegaschool.crmitmega.mapper.CourseMapper;
import kg.itmegaschool.crmitmega.mapper.CourseTypeMapper;
import kg.itmegaschool.crmitmega.model.dto.CourseDto;
import kg.itmegaschool.crmitmega.model.dto.CourseTypeDto;
import kg.itmegaschool.crmitmega.model.entity.Course;
import kg.itmegaschool.crmitmega.model.request.CourseCreateRequest;
import kg.itmegaschool.crmitmega.model.request.GetCourseByCostRequest;
import kg.itmegaschool.crmitmega.repository.CourseRepository;
import kg.itmegaschool.crmitmega.service.CourseService;
import kg.itmegaschool.crmitmega.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseTypeService courseTypeService;

    @Override
    public CourseDto create(CourseCreateRequest request) {
        CourseTypeDto courseTypeDto = courseTypeService.read(request.getCourseTypeId());

        Course course = Course
                .builder()
                .courseName(request.getCourseName())
                .monthlyCost(request.getMonthlyCost())
                .courseType(CourseTypeMapper.INSTANCE.toEntity(courseTypeDto))
                .build();

        courseRepository.save(course);

        return CourseDto
                .builder()
                .id(course.getId())
                .courseType(courseTypeDto)
                .monthlyCost(course.getMonthlyCost())
                .courseName(course.getCourseName())
                .build();
    }

    @Override
    public CourseDto read(Long id) {
        return CourseMapper.INSTANCE
                .toDto(courseRepository.findByIdAndIsDeletedFalse(id)
                        .orElseThrow(() -> new CourseNotFoundException("Course with id=" + id + " not found.")));
    }

    @Override
    public CourseDto update(CourseDto courseDto) {
        return courseRepository.findById(courseDto.getId()).map(course -> {
            course.setCourseName(courseDto.getCourseName());
            course.setMonthlyCost(courseDto.getMonthlyCost());
            courseRepository.save(course);

            return CourseMapper.INSTANCE.toDto(course);
        }).orElseThrow(() -> new CourseNotFoundException("Course with id=" + courseDto.getId() + " not found."));
    }

    public List<String> readAllCourseNames() {
        return courseRepository.findAllCourseNames();
    }

    @Override
    public List<CourseDto> readCoursesByMonthlyCostBetween(GetCourseByCostRequest request) {
        List<CourseDto> courseDtos = CourseMapper.INSTANCE.
                toDtoList(courseRepository.findByMonthlyCostBetween(request.getFrom(), request.getTo()));

        if (courseDtos.isEmpty()) {
            throw new RuntimeException("Empty data set");
        }
        return courseDtos;
    }

    @Override
    public void delete(Long id) {

    }
}
