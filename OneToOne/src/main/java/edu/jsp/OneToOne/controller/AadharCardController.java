package edu.jsp.OneToOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.OneToOne.entity.AadharCard;
import edu.jsp.OneToOne.service.AadharService;

@RestController
@RequestMapping("aadhar")
public class AadharCardController {
	
	@Autowired
	private AadharService aadharService;
	
	@PutMapping()
	public  AadharCard saveAadharCard(@RequestBody AadharCard aadharCard)
	{
		return aadharService.saveAadharCard(aadharCard);
	}
	
	@GetMapping("/{id}")
	public AadharCard getByAadharCard(@PathVariable    long id)
	{
		return aadharService.getByAadharCardId(id);
	}
	
	@PutMapping("/{id}")
	public String updateByAadharCardId(@PathVariable long id,@RequestBody AadharCard aadharCard)
	{
		return aadharService.updateByAadharCardId(id, aadharCard);
	}
	
	@GetMapping("/address")
	public List<AadharCard> getAadharCardAddress(@RequestParam String address)
	{
		return aadharService.getByAadharCardAddress(address);
		
	}
}
