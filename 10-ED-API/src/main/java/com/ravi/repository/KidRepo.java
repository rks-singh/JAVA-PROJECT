package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.KidEntity;

public interface KidRepo extends JpaRepository<KidEntity, Integer> {

	public List<KidEntity> findByCaseNumber(Integer caseNumber);
}
