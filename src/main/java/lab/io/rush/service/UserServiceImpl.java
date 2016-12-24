package lab.io.rush.service;

import javax.annotation.Resource;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Component;

import lab.io.rush.dao.UserDao;
import lab.io.rush.entity.User;

@Component("UserService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userdao;

	@Transactional
	public int login(String username, String password) {
		return userdao.login(username,password);
	}


	@Transactional
	public User findUserByname(String username) {
		
		return userdao.findUserByname(username);
	}

	@Transactional
	public int regist(String mail, String username, String password) {
		return userdao.regist(mail,username,password);
	}

}
