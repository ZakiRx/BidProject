package zoz.bidproject.config;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.OfferService;
import zoz.bidproject.service.SellerService;

@Configuration
@EnableScheduling
@Transactional
public class SchedulingConfig {

	@Autowired
	private OfferService offerService;
	@Autowired
	private SellerService sellerService;
	private Logger logger;
	
	@PostConstruct
	public void initLogger() {
		logger= Logger.getLogger(Offer.class.getName());
	}
	@Async
	@Scheduled(fixedDelayString = "PT1H")
	public void deleteOfferNotContainProducts() throws ParseException {
	
		List<Offer> offers = offerService.getAllOffers();
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Offer offer : offers) {
			
			Date dateNow=simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			Date dateStartOffer= simpleDateFormat.parse(simpleDateFormat.format(offer.getStartedAt()));
	
			if( (offer.getProducts()==null || offer.getProducts().size()==0) && dateStartOffer.before(dateNow)) {
				offerService.deleteOffre(offer);
				logger.info("Offer :"+offer.getName()+" Deleted");
			}
		}
	}
	@Async
	@Scheduled(cron = "0 0 * * *  ?") 
	public void disableofferEnded() throws ParseException {
	
		List<Offer> offers = offerService.getAllOffers();
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Offer offer : offers) {
			
			Date dateNow=simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			Date dateEndOffer= simpleDateFormat.parse(simpleDateFormat.format(offer.getEndAt()));
			if( dateEndOffer.before(dateNow) && offer.getEnabled()) {
				offerService.disableOffer(offer);
				logger.info("Offer :"+offer.getName()+" ended");
			}
		}
	}
	@Async
	@Scheduled(cron = "0 0 * * *  ?") 
	public void disableSubscription() throws ParseException {
	
		List<Seller> sellers = sellerService.getSellers();
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Seller seller : sellers) {
			
			Date dateNow=simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			Date dateEndSubscribe= simpleDateFormat.parse(simpleDateFormat.format(seller.getSubscription().getEndAt()));
			if( dateEndSubscribe.before(dateNow) && seller.getSubscription().isEnabled() ) {
				seller.getSubscription().setEnabled(false);
				logger.info("Subscription of user  :"+seller.getUserName()+" Has ended");
			}
		}
	}
}
