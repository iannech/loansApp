package com.org.mfs.loans.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.org.mfs.loans.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
	@Query("SELECT l FROM Loan l WHERE l.customerId =:customerId")
	List<Loan> findByCustomerId(@Param("customerId") int customerId);
	
	
	@Query("SELECT l FROM Loan l WHERE l.customerId =:customerId AND l.requestDate >= DATEADD(MONTH, -3, GETDATE())")
	List<Loan>findLastThreeMonthsByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT l FROM Loan l WHERE l.customerId =:customerId AND l.loanStatus = :loanStatus")
	List<Loan> findCustomerLoanStatusById(@Param("customerId")int customerId, @Param("loanStatus") String loanStatus);
	
	
	
}
