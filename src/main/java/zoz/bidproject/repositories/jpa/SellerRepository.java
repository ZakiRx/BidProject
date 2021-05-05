package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import zoz.bidproject.model.Seller;
import zoz.bidproject.model.User;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

	@Query("select s from Seller s where s.userName like :username")
	Seller getSellerByUserName(@Param("username") String username);
}
