package kg.itmegaschool.crmitmega.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MentorDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate dob;
    BigDecimal salary;
}
