package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zoz.bidproject.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

	@Query("select s from Seller s where s.accountId like :accountId")
	Seller getOne(@Param("accountId") Long accountId);
}
