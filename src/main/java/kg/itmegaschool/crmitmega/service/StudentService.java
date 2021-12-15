package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.dto.StudentDto;
import kg.itmegaschool.crmitmega.model.request.CreateStudentRequest;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    StudentDto create(CreateStudentRequest request);

}
