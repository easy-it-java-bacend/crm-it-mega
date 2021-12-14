package kg.itmegaschool.crmitmega.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddCourseTypeRequest {
    String typeName;
    Integer classesPerMonth;
    Double durationInMonth;
    LocalTime durationOfOneLesson;
}
