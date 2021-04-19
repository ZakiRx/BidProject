package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoz.bidproject.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
