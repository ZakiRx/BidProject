package zoz.bidproject;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import zoz.bidproject.config.BeansConfig;
import zoz.bidproject.dto.OfferDto;
import zoz.bidproject.model.Bid;
import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Category;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Pack;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Role;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.SubCategory;
import zoz.bidproject.service.BidService;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CategoryService;
import zoz.bidproject.service.OfferService;
import zoz.bidproject.service.PackService;
import zoz.bidproject.service.RoleService;
import zoz.bidproject.service.SellerService;
import zoz.bidproject.service.SubCategoryService;
import zoz.bidproject.service.SubscriptionService;

@SpringBootApplication
public class BidProjectApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(BidProjectApplication.class, args);

		Pack pack = new Pack(null, "premium", 100, "No Detaill");
		PackService packService = applicationContext.getBean("packService", PackService.class);
		SellerService sellerService = applicationContext.getBean("sellerService", SellerService.class);
		RoleService roleService = applicationContext.getBean("roleService",RoleService.class);
		BuyerService buyerService = applicationContext.getBean("buyerService", BuyerService.class);
		OfferService offerService = applicationContext.getBean("offerService", OfferService.class);
		SubscriptionService subscriptionService = applicationContext.getBean("subscriptionService",
				SubscriptionService.class);
		BidService bidService = applicationContext.getBean("bidService", BidService.class);
		CategoryService categoryService = applicationContext.getBean("categoryService",CategoryService.class);
		SubCategoryService subCategoryService = applicationContext.getBean("subCategoryService",SubCategoryService.class);
		Buyer buyer = new Buyer(null, "zaki", "zakaria", "Guemi", new Date(), "zaki@gmail.com", "065231489", "123",
				true, true, 1542L, 50000, true);
		Buyer buyer2 = new Buyer(null, "med", "med", "Guemi", new Date(), "med@gmail.com", "063336489", "123",
				true, true, 1582L, 32600, true);
		OfferDto offerDto = new OfferDto("offer1", "no duscription", 100.0, 500.0);
		Category category = new Category(null,"HardwareSlug1","Hardware PC");
		SubCategory subCategory=new SubCategory(null, "slugRam", "Ram", category);
		Role role= new Role(null,"Buyer");
		Role roleS= new Role(null,"Seller");
		
		
		// add Category to db
		categoryService.newCategory(category);
		
		// add SubCategory to db
		subCategoryService.newSubCategory(subCategory);
		// add pack to db
		packService.newPack(pack);
		// Added New Buyer to Db
		buyerService.newBuyer(buyer);
		buyerService.newBuyer(buyer2);
		//buyerService.addBuyerToRole(buyer, role);
		System.out.println("check buyer is seller :"+buyerService.IsSeller(1L));
		// Added New Subscription & seller  to Db and change status buyer to seller 
		subscriptionService.newSubscription(pack, buyer);
		
		System.out.println("check buyer is seller (after subscripe) :"+buyerService.IsSeller(1L));
		
		///System.out.println(buyerService.getBuyer(1L)); 
		// Added New Offre to Db
	    Seller sellerInDb = sellerService.getSeller(1L);//accountId
		 System.out.println(sellerInDb.getFirstName());
		

		
	
		//buyerService.deleteBuyer(buyer);
		//offerService.deleteOffre(offer);
		
		try {
			
			Offer offer = sellerService.createOffer(sellerInDb, offerDto);
		  // add products to offer
			for (int i = 0; i < 6; i++) {
				Product product = new Product(null, "produit"+i, "description"+i, "image"+i, "images"+i, new Date(), new Date(), true, "tags", offer,subCategory);
				sellerService.addProductForOffer(offer, product);
			}
		Bid bid = new Bid(null,1500.0,buyer,offer);
		bidService.newBid(bid);
		bidService.getBidsByOffer(offer).forEach(b->System.out.println(b.getId()+"-"+b.getPrice()));
		System.out.println("current price:"+offer.getCurrentPrice());
		Bid bid2 = new Bid(null,1700.0,buyer,offer);
		bidService.newBid(bid2);
		bidService.getBidsByOffer(offer).forEach(b->System.out.println(b.getId()+"-"+b.getPrice()));
		System.out.println("current price:"+offer.getCurrentPrice());
		//must be exception
		Bid bid3 = new Bid(null,1400.0,buyer,offer);
		bidService.newBid(bid3);
		bidService.getBidsByOffer(offer).forEach(b->System.out.println(b.getId()+"-"+b.getPrice()));
		System.out.println("current price:"+offer.getCurrentPrice());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
