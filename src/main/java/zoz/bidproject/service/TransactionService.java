package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Transaction;
import zoz.bidproject.repositories.jpa.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction newTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	public List<Transaction> getBuyerTransactions(Buyer buyer) {
		return buyer.getTransactions();
	}
}
