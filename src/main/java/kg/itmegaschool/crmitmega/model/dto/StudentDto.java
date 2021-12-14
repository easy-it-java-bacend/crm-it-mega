package kg.itmegaschool.crmitmega.model.dto;

import kg.itmegaschool.crmitmega.model.entity.Group;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate dob;
    List<Group> group;
}
