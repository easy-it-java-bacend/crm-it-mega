package kg.itmegaschool.crmitmega.repository;

import kg.itmegaschool.crmitmega.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
