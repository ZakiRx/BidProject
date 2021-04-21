package zoz.bidproject;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zoz.bidproject.config.BeansConfig;
import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.OfferService;
import zoz.bidproject.service.PackService;
import zoz.bidproject.service.SellerService;
import zoz.bidproject.service.SubscriptionService;

@SpringBootApplication
public class BidProjectApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(BidProjectApplication.class, args);

		Pack pack = new Pack(null, "premium", 100, "No Detaill");
		PackService packService = applicationContext.getBean("packService", PackService.class);
		SellerService sellerService = applicationContext.getBean("sellerService", SellerService.class);
		OfferService offerService = applicationContext.getBean("offerService", OfferService.class);
		SubscriptionService subscriptionService = applicationContext.getBean("subscriptionService",
				SubscriptionService.class);
		Seller seller = new Seller(null, "zaki", "zakaria", "Guemi", new Date(), "zaki@gmail.com", "065231489", "123",
				true, true, 1542L, 50000, true);
		OfferDto offerDto = new OfferDto("offer1", "no duscription", 100.0, 500.0);

		// add pack to db
		packService.newPack(pack);
		// Added New Seller to Db
		sellerService.newSeller(seller);

		// Added New Subscription to Db
		subscriptionService.newSubscription(pack, sellerService.getSeller(1L));
		// Added New Offre to Db
		Seller sellerInDb = sellerService.getSeller(1L);
		// System.out.println(sellerInDb.getFirstName());
		

		// add products to offer
		Offer offer = sellerService.createOffer(sellerInDb, offerDto);
		for (int i = 0; i < 6; i++) {
			Product product = new Product(null, "produit"+i, "description"+i, "image"+i, "images"+i, new Date(), new Date(), true, "tags", offer,null);
			sellerService.addProductForOffer(offer, product);
		}
		offerService.deleteOffre(offer);
		
		

	}

}
