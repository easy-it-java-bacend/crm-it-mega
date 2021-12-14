package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.exceptions.CourseTypeNotFoundException;
import kg.itmegaschool.crmitmega.mapper.CourseTypeMapper;
import kg.itmegaschool.crmitmega.model.MessageResponse;
import kg.itmegaschool.crmitmega.model.dto.CourseTypeDto;
import kg.itmegaschool.crmitmega.model.entity.CourseType;
import kg.itmegaschool.crmitmega.model.request.AddCourseTypeRequest;
import kg.itmegaschool.crmitmega.repository.CourseTypeRepository;
import kg.itmegaschool.crmitmega.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseTypeServiceImpl implements CourseTypeService {

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @Override
    public CourseTypeDto create(AddCourseTypeRequest request) {
        if (courseTypeRepository.existsByTypeName(request.getTypeName())) {
            CourseType courseType = courseTypeRepository
                    .findByTypeName(request.getTypeName())
                    .map(courseType1 -> {
                        courseType1.setIsDeleted(false);
                        courseType1.setClassesPerMonth(request.getClassesPerMonth());
                        courseType1.setDurationOfOneLesson(request.getDurationOfOneLesson());
                        courseType1.setClassesPerMonth(request.getClassesPerMonth());
                        return courseTypeRepository.save(courseType1);
                    }).get();
            return CourseTypeMapper.INSTANCE.toDto(courseType);
        }

        if (request.getTypeName().equals("") || request.getTypeName() == null) {
            throw new IllegalArgumentException("TypeName should not be empty.");
        }

        if (request.getClassesPerMonth() <= 0 || request.getClassesPerMonth() > 30) {
            throw new IllegalArgumentException("Invalid number of classes for classesPerMonth=" + request.getClassesPerMonth());
        }

        CourseType courseType = new CourseType();
        courseType.setTypeName(request.getTypeName());
        courseType.setClassesPerMonth(request.getClassesPerMonth());
        courseType.setDurationInMonth(request.getDurationInMonth());
        courseType.setDurationOfOneLesson(request.getDurationOfOneLesson());
        courseTypeRepository.save(courseType);

        return CourseTypeDto
                .builder()
                .id(courseType.getId())
                .durationInMonth(courseType.getDurationInMonth())
                .dateCreated(courseType.getDateCreated())
                .classesPerMonth(courseType.getClassesPerMonth())
                .typeName(courseType.getTypeName())
                .durationOfOneLesson(courseType.getDurationOfOneLesson())
                .build();
    }

    @Override
    public CourseTypeDto read(Long id) {
        CourseType courseType = courseTypeRepository
                .findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CourseTypeNotFoundException("For id=" + id));

        return CourseTypeMapper.INSTANCE.toDto(courseType);
    }

    @Override
    public List<CourseTypeDto> readAll() {
        List<CourseType> courseTypeList = courseTypeRepository.findAll();
        if (courseTypeList.isEmpty()) {
            throw new RuntimeException("Table for Course type is empty");
        }
        return CourseTypeMapper.INSTANCE.toDtoList(courseTypeList);
    }

    @Override
    public MessageResponse delete(Long id) {
        return courseTypeRepository
                .findById(id)
                .map(courseType -> {
                    courseType.setIsDeleted(true);
                    courseTypeRepository.save(courseType);
                    return new MessageResponse("Course type with id=" + id + " is deleted.");
                })
                .orElseThrow(() -> new CourseTypeNotFoundException("For id=" + id));
    }
}
