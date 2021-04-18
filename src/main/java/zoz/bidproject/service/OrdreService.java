package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Seller;
import zoz.bidproject.repositories.jpa.OrdreRepository;

@Service
public class OrdreService {
	@Autowired
	private OrdreRepository ordreRepository;
	
	public List<Ordre>  getOrdersBySeller(Seller seller){
		
	}
}
