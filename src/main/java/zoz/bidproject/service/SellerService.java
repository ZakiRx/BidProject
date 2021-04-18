package zoz.bidproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offer;
import zoz.bidproject.dto.OffreDto;
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

	public List<Offer> getOffres(Long idSeller) {

		Seller seller = getSeller(idSeller);
		return offerService.getAllOffresBySeller(seller);
	}

	public Offer createOffre(Long idSeller) {// OffreDto
		Seller seller = getSeller(idSeller);
		Offer offre = new Offer(null, "offre1", "bla bla", 500.0, 100.0, new Date(), new Date(), false, false, seller);
		return offre;
	}

	public Offer createOffre(Long idSeller, OffreDto offreDto) {
		Seller seller = getSeller(idSeller);
		Offer offre = new Offer(null, offreDto.getName(), offreDto.getDescription(), offreDto.getStartPrice(),
				offreDto.getAugmentationPrice(), new Date(), new Date(), false, false, seller);
		return offre;
	}

	public Offer addProductForOffre(Offer offre, Product product) {
		List<Product> productsInOffre = offre.getProducts();
		productsInOffre.add(product);
		offre.setProducts(productsInOffre);
		offre.setEnabled(true);
		return offre;
	}

	public Offer newOffre(Offer offre) {
		return offerService.saveOffre(offre);
	}

	public Offer updateOffre(Offer offre, Long idSeller) {
		Seller seller = getSeller(idSeller);// 1L id seller get in session (Seller connect)
		if (offre.getSeller().equals(seller)) {
			return offerService.saveOffre(offre);
		}
		return null;
	}

	public Offer updateProductInOffre(Offer offre, Product newProduct, Long idSeller) {
		Seller seller = getSeller(idSeller);// 1L id seller get in session (Seller connect)
		if (offre.getSeller().equals(seller)) {

			offre.getProducts().set(newProduct.getId().intValue(), newProduct);
		}

		return offre;
	}

	public List<Product> getProductsInOffre(Offer offre) {
		return productService.getProductsByOffre(offre);
	}

}
