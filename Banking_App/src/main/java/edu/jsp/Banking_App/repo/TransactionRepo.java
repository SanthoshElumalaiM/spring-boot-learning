package edu.jsp.Banking_App.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.Banking_App.entity.Transaction;
import edu.jsp.Banking_App.entity.User;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	List<Transaction> findByAccountUserUidAndDateBetween(User userId,LocalDateTime start,LocalDateTime end);
	
	@Query("select t from  transaction  t where t.account.user.uid =?1 order by date")
	List<Transaction> findByAccountUserUid(long userId);
}
