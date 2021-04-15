package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
