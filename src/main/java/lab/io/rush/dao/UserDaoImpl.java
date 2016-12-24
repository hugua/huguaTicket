package lab.io.rush.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.entity.User;
import lab.io.rush.util.MyPmUtil;
@Component("UserDao")
public class UserDaoImpl implements UserDao{

	public int login(String username, String password) {
		 PersistenceManager pm = MyPmUtil.getPm();
	     Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'"+"&& password =='" + password+"'");
         List<User> holders = (List<User>) q.execute();
         if(holders.size() > 0){
         	return 1;
         }
		return 0;
	}

	public User findUserByname(String username) {
		 PersistenceManager pm = MyPmUtil.getPm();
	     Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'");
	     q.setUnique(true);
	     User user = (User) q.execute();
	     return user;

	}

	public int regist(String mail, String username, String password) {
		int msg ;
		PersistenceManager pm = MyPmUtil.getPm();
		User user = new User(username,password,mail);

		Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'");
		List<User> users = (List<User>) q.execute();
		if(users.size() > 0){
			msg = 0;
		}else{
			msg = 1;
			pm.makePersistent(user);
			
		}
		return msg;
	}
}
