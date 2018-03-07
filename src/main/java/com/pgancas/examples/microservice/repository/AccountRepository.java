package com.pgancas.examples.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgancas.examples.microservice.entity.Account;

/**
 * Persistence repository for accounts
 * 
 * @author peter
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
