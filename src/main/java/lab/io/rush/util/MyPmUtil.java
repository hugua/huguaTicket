package lab.io.rush.util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 用来获取数据源的bean类 PersistenceManagerFactory，并提供PersistenceManager给到层
 * @author chen
 *
 */
public class MyPmUtil {

	private  static PersistenceManager pm;
	private static Transaction tx;
	static{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersistenceManagerFactory pmf = (PersistenceManagerFactory) context.getBean("myPmf");
		pm = pmf.getPersistenceManager();
		tx = pm.currentTransaction();
	}
	public static PersistenceManager getPm() { 
		 return pm;
	}

	public static Transaction getTx(){
		return  tx;
	}
	
}
