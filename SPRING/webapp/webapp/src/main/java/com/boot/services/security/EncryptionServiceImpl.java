package com.boot.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.configuration.CommonBeanConfig;

@Service
public class EncryptionServiceImpl implements EncryptionService{

	@Autowired
	CommonBeanConfig commonBeanConfig;

	@Override
	public String encryptString(String input) {
		return commonBeanConfig.strongEncryptor().encryptPassword(input);
	}

	@Override
	public boolean checkPassword(String plainPassword, String encryptedPassword) {

		return commonBeanConfig.strongEncryptor().checkPassword(plainPassword, encryptedPassword);
	}
}