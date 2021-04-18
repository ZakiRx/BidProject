package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zoz.bidproject.model.Pack;
import zoz.bidproject.repositories.jpa.PackRepository;

public class PackService {

	@Autowired
	private PackRepository packRepository;
	
	public Pack  newPack(Pack pack) {
		return packRepository.save(pack);
	}
	
	public List<Pack> getPacks() {
		return packRepository.findAll();
	}
	public Pack getPack(Long id) {
		return packRepository.getOne(id);
	}
	public Boolean deletePack(Long id) {
		Pack pack=getPack(id);
		if(pack !=null) {
			 packRepository.delete(pack);
			 return true;
		}
		return false;
	}
	
}
