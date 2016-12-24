package lab.io.rush.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lab.io.rush.dao.UserDao;
import lab.io.rush.entity.User;

/**
 * 用户类业务层接口
 * @author chen
 *
 */
public interface UserService {
	/**
	 * 判断登录是否成功
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功返回1,失败返回0
	 */
	public int login(String username, String password);


	/**
	 * 根据名字查找用户
	 * @param username 用户名
	 * @return 返回用户对象
	 */
	public User findUserByname(String username);


	/**
	 * 注册
	 * @param mail 邮箱
	 * @param username 用户名
	 * @param password 密码
	 * @return 返回
	 */
	public int regist(String mail, String username, String password) ;



}
