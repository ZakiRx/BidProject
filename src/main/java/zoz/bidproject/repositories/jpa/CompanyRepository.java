package zoz.bidproject.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
