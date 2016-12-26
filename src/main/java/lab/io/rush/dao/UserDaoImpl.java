package lab.io.rush.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.entity.User;

@Component("UserDao")
public class UserDaoImpl implements UserDao{

	@Resource(name="myPmf")
	private PersistenceManagerFactory pmf;
	public int login(String username, String password) {
		 PersistenceManager pm = pmf.getPersistenceManager();
	     Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'"+"&& password =='" + password+"'");
         List<User> holders = (List<User>) q.execute();
         pm.close();
         if(holders.size() > 0){
         	return 1;
         }
		return 0;
	}

	public User findUserByname(String username) {
		PersistenceManager pm = pmf.getPersistenceManager();
	     Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'");
	     q.setUnique(true);
	     User user = (User) q.execute();
	     pm.close();
	     return user;

	}

	public int regist(String mail, String username, String password) {
		int msg ;
		PersistenceManager pm = pmf.getPersistenceManager();
		User user = new User(username,password,mail);

		Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'");
		List<User> users = (List<User>) q.execute();
		if(users.size() > 0){
			msg = 0;
		}else{
			msg = 1;
			pm.makePersistent(user);
			
		}
		pm.close();
		return msg;
	}
}
