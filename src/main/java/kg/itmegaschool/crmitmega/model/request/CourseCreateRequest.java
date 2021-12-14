package kg.itmegaschool.crmitmega.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseCreateRequest {
    String courseName;
    BigDecimal monthlyCost;
    Long courseTypeId;
}
