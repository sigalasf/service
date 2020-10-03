package com.boot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entites.User;
import com.boot.repositories.UserRepository;
import com.boot.services.security.EncryptionService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private EncryptionService encryptionService;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<User> listAll() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User getById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User saveOrUpdate(User domainObject) {
		if (domainObject.getPassword() != null) {
			domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
		}
		return userRepository.save(domainObject);
	}
}