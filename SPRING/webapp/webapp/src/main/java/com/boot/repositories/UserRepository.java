package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entites.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	User findByUsername(String username);
}
