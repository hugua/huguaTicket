package lab.io.rush.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.entity.Film;


@Component("TicketDao")
public class TicketDaoImpl  implements TicketDao{
	
	@Resource(name="myPmf")
	private PersistenceManagerFactory pmf;
	public Film getfilmByid(String filmid) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName() +" WHERE id == "+ filmid);
		q.setUnique(true);
		Film film= (Film)q.execute();
		pm.close();
		return film;
	}


	public List<Film> findSellingTicket() {
//		PersistenceManager pm = MyPmUtil.getPm();
		PersistenceManager pm = pmf.getPersistenceManager();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName()+" WHERE number > 0") ;
		List<Film> films= (List<Film>)q.execute();	
		pm.close();
		return films;
	}


	public List<Film> findTicket() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName()) ;
		List<Film> films= (List<Film>)q.execute();	
		pm.close();
		return films;
	}
}
