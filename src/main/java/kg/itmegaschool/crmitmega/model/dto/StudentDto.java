package kg.itmegaschool.crmitmega.model.dto;

import kg.itmegaschool.crmitmega.model.entity.Group;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate dob;
    List<GroupDto> group;
}
