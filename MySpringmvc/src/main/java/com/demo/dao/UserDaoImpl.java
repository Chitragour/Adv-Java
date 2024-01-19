package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
 
	public User checkUser(String unm, String password) {
		try {
		  String str="select uname,password from user where uname=? and password=?";
		  return jdbcTemplate.queryForObject(str, new Object[] {unm,password},BeanPropertyRowMapper.newInstance(User.class));
		}catch(EmptyResultDataAccessException e) {
			System.out.println("not found"+e.getMessage());
			return null;
		}
	}

}
