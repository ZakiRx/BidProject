package zoz.bidproject.repositories.jpa;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zoz.bidproject.model.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
	@Transactional
	@Modifying
	@Query("Update Buyer set type=:typeAccount where id=:idBuyer")
	void editTypeAccount(@Param("typeAccount") String type, @Param("idBuyer") Long id);
	
	@Query("select b from Buyer b where b.userName like :username")
	Buyer findOneByUsername(@Param("username")String username);
	
}
