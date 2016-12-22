package lab.io.rush.Dao;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.Entity.user2ticket;
import lab.io.rush.Util.MyPmUtil;

@Component
public class User2TicketDao {

	public void save(List<user2ticket> userticket) {
		PersistenceManager pm = MyPmUtil.getPm();
		Transaction tx = MyPmUtil.getTx();
		tx.begin();
		for(int i=0;i<userticket.size();i++)
			pm.makePersistent(userticket.get(i));
		tx.commit();
	}

}
