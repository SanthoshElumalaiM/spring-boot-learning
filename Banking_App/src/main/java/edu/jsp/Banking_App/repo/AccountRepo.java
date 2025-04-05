package edu.jsp.Banking_App.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.Banking_App.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	
	@Query(value="select a from Account a where a.user.uid=:uid")
	List<Account> getAccountByUserId(@Param("uid") Long userId);

}
