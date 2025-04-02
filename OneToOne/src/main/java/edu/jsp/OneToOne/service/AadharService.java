package edu.jsp.OneToOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.OneToOne.entity.AadharCard;
import edu.jsp.OneToOne.repo.AadharCardRepo;

@Service
public class AadharService {
	
	@Autowired
	private  AadharCardRepo aadharCardRepo;
	
	public AadharCard saveAadharCard(AadharCard aadharCard)
	{
		return aadharCardRepo.save(aadharCard);
	}
	
	public AadharCard getByAadharCardId(long id)
	{
			 Optional< AadharCard> a =aadharCardRepo.findById(id);
			 
			 return a.isPresent()?a.get():null;
	}
	
	public String updateByAadharCardId(long id,AadharCard newAadharCard)
	{
		AadharCard  exAadharCard=  getByAadharCardId(id);
		
		if(exAadharCard!=null) {
			
			newAadharCard.setAid(id);
			aadharCardRepo.save(newAadharCard);
			return "data udated";
			
		}
		return "data not found";
	}
	
	public List<AadharCard> getByAadharCardAddress(String address){
		return aadharCardRepo.getByAadharCardAddress(address);
	}
	

}
