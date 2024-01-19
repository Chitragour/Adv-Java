package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.User;

@Service
public class UserserviceImpl implements UserService {
	
	@Autowired
	private UserDao udao;

	@Override
	public User validateUser(String unm, String password) {
		// TODO Auto-generated method stub
		return udao.checkUser(unm,password);
	}

}
