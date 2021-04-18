package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Seller getSeller(Long id) {
		return sellerRepository.getOne(id);// 1L id seller get in session
	}

	/**
	 * Subscribe Seller with select One pack
	 * 
	 * @param {@link   Pack}
	 * @param idSeller
	 * @return
	 */
	public Subscription newSubscription(Pack pack, Long idSeller) {
		Seller seller = getSeller(idSeller);
		Subscription subscription = subscriptionService.newSubscription(pack, seller);
		return subscription;
	}

	/**
	 * Get all offers seller
	 * 
	 * @param idSeller
	 * @return
	 */
	public List<Offer> getOffers(Long idSeller) {

		Seller seller = getSeller(idSeller);
		return offerService.getAllOffresBySeller(seller);
	}

	/**
	 * when seller want to create offer first time, without products
	 * 
	 * @param idSeller
	 * @param offerDto
	 * @return
	 */
	public Offer createOffer(Long idSeller, OfferDto offerDto) {
		Seller seller = getSeller(idSeller);
		Offer offre = new Offer(null, offerDto.getName(), offerDto.getDescription(), offerDto.getStartPrice(),
				offerDto.getAugmentationPrice(), new Date(), new Date(), false, false, seller);
		return offre;
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
		productsInOffre.add(product);
		offer.setProducts(productsInOffre);
		offer.setEnabled(true);
		return offer;
	}

	public Offer newOffer(Offer offer) {
		return offerService.saveOffre(offer);
	}

	public Offer updateOffer(Offer offer, Long idSeller) {
		Seller seller = getSeller(idSeller);// 1L id seller get in session (Seller connect)
		if (offer.getSeller().equals(seller)) {
			return offerService.saveOffre(offer);
		}
		return null;
	}

	public Offer updateProductInOffer(Offer offer, Product newProduct, Long idSeller) {
		Seller seller = getSeller(idSeller);// 1L id seller get in session (Seller connect)
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

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkSubscription(Long id) {
		Seller seller = getSeller(id);
		return subscriptionService.checkSubscription(seller);
	}

	public List<Follow> getFollowers(Long id) {
		Seller seller = getSeller(id);
		return followService.getFollowersBySeller(seller);
	}

}
