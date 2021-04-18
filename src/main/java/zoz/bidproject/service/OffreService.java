package zoz.bidproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offre;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.OffreRepository;

@Service
public class OffreService {

	private OffreRepository offreRepository;
	
	public List<Offre> getAllOffres(){
		return offreRepository.findAll();
	}
	public List<Offre> getAllOffresBySeller(Seller seller){
		return seller.getOffres();
	}
	
	public  Offre saveOffre(Offre offre) {
		return offreRepository.save(offre);
	}
	
	
	
}
