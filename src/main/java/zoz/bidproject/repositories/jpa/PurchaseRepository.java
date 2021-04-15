package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
