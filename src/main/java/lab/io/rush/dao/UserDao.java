package lab.io.rush.Dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.Entity.User;
import lab.io.rush.Util.MyPmUtil;

@Component
public class UserDao {


	public int login(String username, String password) {
		 PersistenceManager pm = MyPmUtil.getPm();
	     Transaction tx = MyPmUtil.getTx();
	     tx.begin();
	     Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'"+"&& password =='" + password+"'");
         List<User> holders = (List<User>) q.execute();
         if(holders.size() > 0){
        	tx.commit();
         	return 1;
         }
         tx.commit();
		return 0;
	}

	public User findUserByname(String username) {
		 PersistenceManager pm = MyPmUtil.getPm();
	     Transaction tx = MyPmUtil.getTx();
	     tx.begin();
	     Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'");
	     q.setUnique(true);
	     User user = (User) q.execute();
	     tx.commit();
	     return user;

	}

	public String regist(String mail, String username, String password) {
		String msg  = "";
		PersistenceManager pm = MyPmUtil.getPm();
	    Transaction tx = MyPmUtil.getTx();
	    tx.begin();
		User user = new User(username,password,mail);

		Query q = pm.newQuery("SELECT FROM " + User.class.getName()+"  WHERE name == '"+username+"'");
		List<User> users = (List<User>) q.execute();
		if(users.size() > 0){
			msg = "用户已存在";
		}else{
			msg = "注册成功，请登陆";
			pm.makePersistent(user);
			
		}
		tx.commit();
		return msg;
	}

}
