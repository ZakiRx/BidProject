package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
