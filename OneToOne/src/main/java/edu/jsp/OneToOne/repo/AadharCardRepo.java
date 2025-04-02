package edu.jsp.OneToOne.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.OneToOne.entity.AadharCard;

public interface AadharCardRepo extends JpaRepository<AadharCard, Long> {

	@Query(value="select a from AadharCard a where a.address like %:address%")
	List<AadharCard> getByAadharCardAddress(@Param("address") String address);
	
}
