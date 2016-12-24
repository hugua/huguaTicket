package lab.io.rush.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.entity.Film;
import lab.io.rush.util.MyPmUtil;

@Component("TicketDao")
public class TicketDaoImpl  implements TicketDao{
	
	
	public Film getfilmByid(String filmid) {
		PersistenceManager pm = MyPmUtil.getPm();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName() +" WHERE id == "+ filmid);
		q.setUnique(true);
		Film film= (Film)q.execute();
		return film;
	}


	public List<Film> findSellingTicket() {
		PersistenceManager pm = MyPmUtil.getPm();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName()+" WHERE number > 0") ;
		List<Film> films= (List<Film>)q.execute();	
		return films;
	}


	public List<Film> findTicket() {
		PersistenceManager pm = MyPmUtil.getPm();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName()) ;
		List<Film> films= (List<Film>)q.execute();	
		return films;
	}
}
