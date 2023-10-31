package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity,Integer> {

}
