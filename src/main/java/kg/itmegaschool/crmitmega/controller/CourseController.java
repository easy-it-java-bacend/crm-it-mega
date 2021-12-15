package kg.itmegaschool.crmitmega.controller;

import kg.itmegaschool.crmitmega.exceptions.CourseNotFoundException;
import kg.itmegaschool.crmitmega.exceptions.CourseTypeNotFoundException;
import kg.itmegaschool.crmitmega.model.MessageResponse;
import kg.itmegaschool.crmitmega.model.dto.CourseDto;
import kg.itmegaschool.crmitmega.model.request.CourseCreateRequest;
import kg.itmegaschool.crmitmega.model.request.GetCourseByCostRequest;
import kg.itmegaschool.crmitmega.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<?> createCourse(@RequestBody CourseCreateRequest request) {
        try {
            log.info("Creating course...");
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(request));
        } catch (CourseTypeNotFoundException ex) {
            log.error("Course creation failed. Course type not found for id=" + request.getCourseTypeId());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        } /*catch (IllegalArgumentException ex) {

        }*/
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findCourse(@PathVariable Long id) {
        try {
            log.info("Reading course with id=" + id);
            return ResponseEntity.ok(courseService.find(id));
        } catch (CourseNotFoundException ex) {
            log.error("Reading failed. " + ex.getMessage());
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        }
    }

    @GetMapping("/find-all-course-names")
    public ResponseEntity<?> findAllCourseNames() {
        return ResponseEntity.ok(courseService.findAllCourseNames());
    }

    @GetMapping("/find-all-by-cost")
    public ResponseEntity<?> findAllByCost(@RequestBody GetCourseByCostRequest request) {
        return ResponseEntity.ok(courseService.findCoursesByMonthlyCostBetween(request));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody CourseDto courseDto) {
        try {
            log.info("Updating all course fields...");
            return ResponseEntity.ok(courseService.update(courseDto));
        } catch (CourseNotFoundException ex) {
            log.error(ex.getMessage() + " Check stack trace below.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        }
    }
}
