package kg.itmegaschool.crmitmega.repository;

import kg.itmegaschool.crmitmega.model.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, Long> {
    boolean existsByTypeName(String typeName);
    Optional<CourseType> findByTypeName(String typeName);
    Optional<CourseType> findByIdAndIsDeletedFalse(Long id);
}
