package kg.itmegaschool.crmitmega.model.dto;

import kg.itmegaschool.crmitmega.model.entity.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    Long id;
    String courseName;
    BigDecimal monthlyCost;
    CourseTypeDto courseType;
}

/*
{   "id" : 1,
    "courseName" : "Java",
    "monthlyCost" : "12000",
    "courseType" : 1
} -> JSON -> JavaScript Object notation
 */
