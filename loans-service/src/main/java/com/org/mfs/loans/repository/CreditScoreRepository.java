package com.org.mfs.loans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.mfs.loans.model.CreditStatus;

@Repository
public interface CreditScoreRepository extends JpaRepository<CreditStatus, Integer>{

	@Query("SELECT s FROM CreditStatus s WHERE s.customerId = :customerId")
	Optional<CreditStatus> findCreditScoreByCustomerId(@Param("customerId") int customerId);
}
