package zoz.bidproject.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zoz.bidproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	/*@Query("select p from Product p join Offer of where p.offre.seller.id like :idSeller ")
	List<Product> getProductsBySeller(@Param("idSeller") Long id);*/
}
