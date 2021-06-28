package zoz.bidproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.ShippingProof;
import zoz.bidproject.repositories.jpa.ShippingProofRepository;
@Service
public class ShippingProofService {
	
	@Autowired
	private ShippingProofRepository proofRepository;

	public ShippingProof newShippingProof(ShippingProof shippingProof) {
		return proofRepository.save(shippingProof);
	}
	public List<ShippingProof> getShippingProofsNotVerified() {
		return proofRepository.findAll().stream().filter(p->p.getVerified()==false).collect(Collectors.toList());
	}
	

}
