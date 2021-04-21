package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoz.bidproject.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
