package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
