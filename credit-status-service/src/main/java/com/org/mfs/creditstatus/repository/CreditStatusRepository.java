package com.org.mfs.creditstatus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.mfs.creditstatus.model.CreditStatus;

@Repository
public interface CreditStatusRepository extends JpaRepository<CreditStatus, Integer>{
	
	@Query("SELECT s FROM CreditStatus s WHERE s.customerId =:customerId")
	List<CreditStatus> findCreditScoreByCustomerId(@Param("customerId") int customerId);
}
