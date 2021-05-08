package zoz.bidproject.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zoz.bidproject.model.Ordre;

public interface OrderRepository extends JpaRepository<Ordre, Long> {

	/*@Query("select o from Ordre o inner join Seller s on s.id = :idSeller")
	public List<Ordre> getOrdreBySeller(@Param("idSeller") Long idSeller);*/
}
