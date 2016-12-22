package lab.io.rush.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lab.io.rush.Dao.User2TicketDao;
import lab.io.rush.Entity.user2ticket;

@Component
public class User2TicketService {

	@Resource
	private User2TicketDao user2TicketDao;	
	

	public void save(List<user2ticket> userticket) {
		user2TicketDao.save(userticket);
		
	}

}
