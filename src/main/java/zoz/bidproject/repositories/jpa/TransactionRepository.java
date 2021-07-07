package zoz.bidproject.repositories.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import zoz.bidproject.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
