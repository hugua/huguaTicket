package lab.io.rush.Dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.Entity.Film;
import lab.io.rush.Util.MyPmUtil;

@Component
public class TicketDao {


	public Film getfilmByid(String filmid) {
		PersistenceManager pm = MyPmUtil.getPm();
		Transaction tx = MyPmUtil.getTx();
		tx.begin();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName() +" WHERE id == "+ filmid);
		q.setUnique(true);
		Film film= (Film)q.execute();
		tx.commit();
		return film;
	}


	public List<Film> findSellingTicket() {
		PersistenceManager pm = MyPmUtil.getPm();
		Transaction tx = MyPmUtil.getTx();
		tx.begin();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName()+" WHERE number > 0") ;
		List<Film> films= (List<Film>)q.execute();
		tx.commit();	
		return films;
	}


	public List<Film> findTicket() {
		PersistenceManager pm = MyPmUtil.getPm();
		Transaction tx = MyPmUtil.getTx();
		tx.begin();
		Query q = pm.newQuery("SELECT FROM " + Film.class.getName()) ;
		List<Film> films= (List<Film>)q.execute();
		tx.commit();	
		return films;
	}

}
