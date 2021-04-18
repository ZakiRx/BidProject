package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.repositories.jpa.SellerRepository;
import zoz.bidproject.repositories.jpa.SubscriptionRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private OfferService offerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrdreService ordreService;
	
	
	public Seller getSeller(Long id) {
		return sellerRepository.getOne(id);//1L id seller get in session 
	}
	public Subscription newSubscription(Pack pack) {
		Subscription subscription = subscriptionService.newSubscription(pack, 1L); //1L id seller get in session 
		return subscription;
	}
	public List<Offer> getOffres(Long idSeller){
		Seller seller = getSeller(idSeller);
		return offerService.getAllOffresBySeller(seller);
	}
	public Offer createOffre(Long idSeller)  {//OffreDto
		Seller seller = getSeller(idSeller);
		Offer offre = new Offer(null, "offre1", "bla bla", 500.0, 100.0, new Date(), new Date(), false, false, seller);
		return offre;
	}

	public Offer addProductForOffre(Offer offer , Product product) {
		List<Product> productsInOffre = offer.getProducts();
		productsInOffre.add(product);
		offer.setProducts(productsInOffre);
		return offer;
	}
	public Offer saveOffre(Offer offer) {
		return offerService.saveOffre(offer);
	}
	

	
	
	
	
	
	
}
