package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import zoz.bidproject.model.Offer;
=======
import zoz.bidproject.dto.OffreDto;
import zoz.bidproject.model.Offre;
>>>>>>> services
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.Subscription;
import zoz.bidproject.repositories.jpa.SellerRepository;

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
		return sellerRepository.getOne(id);// 1L id seller get in session
	}

	public Subscription newSubscription(Pack pack) {
		Subscription subscription = subscriptionService.newSubscription(pack, 1L); // 1L id seller get in session
		return subscription;
	}
<<<<<<< HEAD
	public List<Offer> getOffres(Long idSeller){
=======

	public List<Offre> getOffres(Long idSeller) {
>>>>>>> services
		Seller seller = getSeller(idSeller);
		return offerService.getAllOffresBySeller(seller);
	}
<<<<<<< HEAD
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
=======

	public Offre createOffre(Long idSeller, OffreDto offreDto) {
		Seller seller = getSeller(idSeller);
		Offre offre = new Offre(null, offreDto.getName(), offreDto.getDescription(), offreDto.getStartPrice(),
				offreDto.getAugmentationPrice(), new Date(), new Date(), false, false, seller);
		return offre;
	}

	public Offre addProductForOffre(Offre offre, Product product) {
		List<Product> productsInOffre = offre.getProducts();
		productsInOffre.add(product);
		offre.setProducts(productsInOffre);
		offre.setEnabled(true);
		return offre;
	}

	public Offre newOffre(Offre offre) {
		return offreService.saveOffre(offre);
>>>>>>> services
	}

	public Offre updateOffre(Offre offre, Long idSeller) {
		Seller seller = getSeller(idSeller);// 1L id seller get in session (Seller connect)
		if (offre.getSeller().equals(seller)) {
			return offreService.saveOffre(offre);
		}
		return null;
	}

	public Offre updateProductInOffre(Offre offre, Product newProduct, Long idSeller) {
		Seller seller = getSeller(idSeller);// 1L id seller get in session (Seller connect)
		if (offre.getSeller().equals(seller)) {

			offre.getProducts().set(newProduct.getId().intValue(), newProduct);
		}

		return offre;
	}

	public List<Product> getProductsInOffre(Offre offre) {
		return productService.getProductsByOffre(offre);
	}

}
