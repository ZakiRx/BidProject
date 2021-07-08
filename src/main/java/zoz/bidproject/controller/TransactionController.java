package zoz.bidproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Transaction;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private BuyerService buyerService;
	@RequestMapping("/")
	@PostAuthorize("hasAuthority('BUYER')")
	public List<Transaction> getTransactions() {
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Buyer buyer = buyerService.getBuyerByUserName(username);
		return transactionService.getBuyerTransactions(buyer);
	}
}
