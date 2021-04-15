package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
