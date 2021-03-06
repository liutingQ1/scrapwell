package com.changqin.well.dao.Impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.changqin.well.dao.UserDAO;
import com.changqin.well.entry.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO{

	@Override
	public User selectOne(String username, String password) {
        String sql = "from User where username = ? and password = ?";
        Query query = getSession().createQuery(sql);
        query.setString(0, username);
        query.setString(1, password);
        User result = (User) query.uniqueResult();
        return result;
	}

	@Override
	public User selectOne(Integer userId) {
		 String sql = "from User where id = ?";
	     Query query = getSession().createQuery(sql);
	     query.setInteger(0, userId);
	     User result = (User) query.uniqueResult();
	     return result;
	}

	@Override
	public User selectOne(String username) {
		String sql = "from User where username = ? ";
        Query query = getSession().createQuery(sql);
        query.setString(0, username);
        User result = (User) query.uniqueResult();
        return result;
	}

}
