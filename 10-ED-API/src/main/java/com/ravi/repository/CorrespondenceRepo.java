package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.CorrespondenceEntity;

public interface CorrespondenceRepo extends JpaRepository<CorrespondenceEntity, Integer> {

}
