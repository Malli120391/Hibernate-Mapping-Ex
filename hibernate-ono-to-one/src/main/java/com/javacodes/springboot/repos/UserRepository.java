package com.javacodes.springboot.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacodes.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
