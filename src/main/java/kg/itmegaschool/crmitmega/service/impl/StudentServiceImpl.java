package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.mapper.StudentMapper;
import kg.itmegaschool.crmitmega.model.dto.GroupDto;
import kg.itmegaschool.crmitmega.model.dto.StudentDto;
import kg.itmegaschool.crmitmega.model.request.CreateStudentRequest;
import kg.itmegaschool.crmitmega.repository.StudentRepository;
import kg.itmegaschool.crmitmega.service.GroupService;
import kg.itmegaschool.crmitmega.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupService groupService;

    @Override
    public StudentDto create(CreateStudentRequest request) {
        List<GroupDto> groupDtoList = Arrays.asList(groupService.find(request.getGroupId()));

        StudentDto studentDto = StudentDto
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dob(request.getDob())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .group(groupDtoList)
                .build();

        studentDto
                .setId(studentRepository
                        .save(StudentMapper.INSTANCE
                                .toEntity(studentDto))
                        .getId());

        return studentDto;
    }
}
