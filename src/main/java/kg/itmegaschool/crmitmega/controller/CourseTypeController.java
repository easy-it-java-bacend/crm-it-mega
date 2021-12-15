package kg.itmegaschool.crmitmega.controller;

import kg.itmegaschool.crmitmega.model.MessageResponse;
import kg.itmegaschool.crmitmega.model.request.CreateCourseTypeRequest;
import kg.itmegaschool.crmitmega.service.CourseTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course-type")
public class CourseTypeController {

    private final CourseTypeService courseTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> createCourseType(@RequestBody CreateCourseTypeRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(courseTypeService.create(request));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> readCourseType(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseTypeService.read(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/read-all")
    public ResponseEntity<?> readAllCourseTypes() {
        try {
            return ResponseEntity.ok(courseTypeService.readAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourseType(@PathVariable Long id) {
        try {
            log.info("Deleting course type with id=" + id);
            return ResponseEntity.ok(courseTypeService.delete(id));
        } catch (RuntimeException ex) {
            log.error("Deleting failed. " + ex.getMessage() + ". For more details check stack trace.");
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageResponse(ex.getMessage()));
        }
    }
}
