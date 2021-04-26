package zoz.bidproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;

	@GetMapping
	@RequestMapping("/")
	public List<Seller> getSellers() {
		return sellerService.getSellers();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Seller getSeller(@PathVariable Long id) {
		return sellerService.getSeller(id);
	}

	@PostMapping
	@RequestMapping("/new")
	public Seller addSeller(@RequestBody Seller Seller) {
		return sellerService.newSeller(Seller);
	}

	@PutMapping
	@RequestMapping("/edit")
	public Seller editSeller(@RequestBody Seller Seller) {
		return sellerService.newSeller(Seller);
	}

	@DeleteMapping
	@RequestMapping("/delete")
	public void deleteSeller(@PathVariable Long id) {
		Seller seller=sellerService.getSeller(id);
		 sellerService.deleteSeller(seller);
	}
}
