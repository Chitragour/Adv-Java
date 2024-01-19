package com.demo.dao;

import com.demo.model.User;

public interface UserDao {

	User checkUser(String unm, String password);

}
