package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.IncomeEntity;

public interface IncomeRepo extends JpaRepository<IncomeEntity, Integer> {

	public IncomeEntity findByCaseNumber(Integer caseNumber);
}
