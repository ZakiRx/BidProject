package zoz.bidproject.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.OfferRepository;

/**
 * 
 * @author othmane
 *
 */
@Service
@Transactional
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;

	/**
	 * 
	 * @param id
	 * @return offer
	 */
	public Offer getOfferById(Long id) {
		try {
			return offerRepository.getOne(id);
		} catch (Exception e) {
			return null; 
		}
		
	}

	/**
	 * 
	 * @return list of offers
	 */
	public List<Offer> getAllOffers() {

		return offerRepository.findAll();
	}

	/**
	 * 
	 * @return list of offers
	 */
	public List<Offer> getEnabledAndVerifiedOffers() {

		return offerRepository.findAll().stream().filter(o -> o.getEnabled() == true && o.getVerified() == true)
				.collect(Collectors.toList());
	}

	public Offer getEnabledAndVerifiedOffer(Long id) {

		Offer offer = offerRepository.getOne(id);
		try {

			if (offer.getEnabled()==true && offer.getVerified()==true) {
				return offer;
			}

			else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @param seller
	 * @return list of offers by seller
	 */
	public List<Offer> getAllOffresBySeller(Seller seller) {
		return seller.getOffres();
	}

	public Boolean verifedOffer(Offer offer) {
		try {
			offer.setVerified(true);
			offerRepository.save(offer);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * 
	 * @param offer
	 * @return offer
	 */
	public Offer saveOffre(Offer offer) {
		return offerRepository.save(offer);
	}

	public void deleteOffre(Offer offer) {
		offerRepository.delete(offer);
	}

	public Boolean disableOffer(Offer offer) {
		try {
			offer.setEnabled(false);
			offerRepository.save(offer);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
