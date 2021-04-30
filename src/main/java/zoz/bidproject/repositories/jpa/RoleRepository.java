package zoz.bidproject.repositories.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zoz.bidproject.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
@Query("select r from Role r where r.nameRole like :rolename")
Role findByName(@Param("rolename") String roleName);
}
