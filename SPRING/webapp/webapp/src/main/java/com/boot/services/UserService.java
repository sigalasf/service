package com.boot.services;

import com.boot.entites.User;

public interface UserService extends CRUDService<User> {

	User findByUsername(String username);

}
