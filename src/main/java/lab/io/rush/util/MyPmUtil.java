package lab.io.rush.Util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class MyPmUtil {

	private  static PersistenceManager pm;
	private static Transaction tx;
	static{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("MyTest");
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
