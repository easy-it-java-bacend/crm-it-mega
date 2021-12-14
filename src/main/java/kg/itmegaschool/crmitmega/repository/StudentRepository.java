package kg.itmegaschool.crmitmega.repository;

import kg.itmegaschool.crmitmega.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Database
public interface StudentRepository extends JpaRepository<Student, Long> {
}
