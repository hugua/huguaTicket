package lab.io.rush.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lab.io.rush.Dao.UserDao;
import lab.io.rush.Entity.User;

@Component
public class UserService {
	@Resource
	private UserDao userdao;

	public int login(String username, String password) {
		return userdao.login(username,password);
	}


	public User findUserByname(String username) {
		
		return userdao.findUserByname(username);
	}


	public String regist(String mail, String username, String password) {
		return userdao.regist(mail,username,password);
	}

}
