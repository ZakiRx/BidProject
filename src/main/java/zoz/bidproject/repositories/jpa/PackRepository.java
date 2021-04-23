package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoz.bidproject.model.Pack;


public interface PackRepository extends JpaRepository<Pack, Long> {

}
