package com.payment_terms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment_terms.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
