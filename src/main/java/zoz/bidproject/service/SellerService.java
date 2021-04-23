package zoz.bidproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import net.bytebuddy.implementation.bytecode.Throw;
import zoz.bidproject.model.Follow;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.repositories.jpa.FollowRepository;
import zoz.bidproject.repositories.jpa.SellerRepository;

/**
 * @author Zaki_Rx
 *
 */
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

	@Autowired
	private FollowService followService;

	/**
	 * check Seller is connected by id stored in Session
	 * 
	 * @param id
	 * @return {@link Seller}
	 */
	public Seller getSeller(Long accountId) {
		Seller seller = sellerRepository.getOne(accountId);
		return seller;
	}
	
	public Seller newSeller(Seller seller) {
		return sellerRepository.save(seller);
	}
	public void deleteSeller(Seller seller) {
		sellerRepository.delete(seller);
	}

	/**
	 * Subscribe Seller with select One pack
	 * 
	 * @param {@link   Pack}
	 * @param idSeller
	 * @return
	 */
	public Subscription newSubscription(Pack pack, Long accountId) throws  Exception {
		Seller seller = getSeller(accountId);
		if(seller==null) {
			 new Exception("\"User not found\"");
		}
		Subscription subscription = subscriptionService.newSubscription(pack, seller);
		return subscription;
	}

	/**
	 * Get all offers seller
	 * 
	 * @param idSeller
	 * @return
	 */
	public List<Offer> getOffers(Seller seller) {
		return offerService.getAllOffresBySeller(seller);
	}

	/**
	 * when seller want to create offer first time, without products
	 * 
	 * @param idSeller
	 * @param offerDto
	 * @return
	 */
	public Offer createOffer(Seller seller, OfferDto offerDto) {
		if(getSeller(seller.getAccountId())!=null) {
			Offer offer = new Offer(null, offerDto.getName(), offerDto.getDescription(), offerDto.getStartPrice(),
					offerDto.getAugmentationPrice(), new Date(), new Date(), false, false, seller);
			saveOffer(offer);
			return offer; 
		}
	
		return null;
	}

	/**
	 * add products to offer and turn true to enabled
	 * 
	 * @param offer
	 * @param product
	 * @return
	 */
	public Offer addProductForOffer(Offer offer, Product product) {
		List<Product> productsInOffre = offer.getProducts();
		if(productsInOffre==null) {
			productsInOffre= new ArrayList<Product>();
		}
		productsInOffre.add(product);
		offer.setProducts(productsInOffre);
		offer.setEnabled(true);
		productService.saveProduct(product);
		saveOffer(offer);
		return offer;
	}

	public void saveOffer(Offer offer) {
		offerService.saveOffre(offer);
	}

	public Offer updateOffer(Offer offer, Long accountId) {
		Seller seller = getSeller(accountId);// 1L Accountid seller get in session (Seller connect)
		if (offer.getSeller().equals(seller)) {
			return offerService.saveOffre(offer);
		}
		return null;
	}

	public Offer updateProductInOffer(Offer offer, Product newProduct, Long accountId) {
		Seller seller = getSeller(accountId);
		if (offer.getSeller().equals(seller)) {
			offer.getProducts().set(newProduct.getId().intValue(), newProduct);
		}

		return offer;
	}

	public List<Product> getProductsInOffer(Offer offer) {
		return productService.getProductsByOffre(offer);
	}

	public List<Ordre> getOrdersSeller(Long id) {
		return ordreService.getOrdersBySeller(id);
	}



	public List<Follow> getFollowers(Long id) {
		Seller seller = getSeller(id);
		return followService.getFollowersBySeller(seller);
	}
	

}
