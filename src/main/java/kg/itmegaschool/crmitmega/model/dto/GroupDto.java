package kg.itmegaschool.crmitmega.model.dto;

import kg.itmegaschool.crmitmega.model.entity.Course;
import kg.itmegaschool.crmitmega.model.entity.Mentor;
import kg.itmegaschool.crmitmega.model.entity.Student;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupDto {
    Long id;
    String groupName;
    Course course;
    Mentor mentor;
    List<Student> students;
    LocalTime classTime;
}
