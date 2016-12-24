package lab.io.rush.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import lab.io.rush.Dao.TicketDao;
import lab.io.rush.Entity.Film;

@Component
public class TicketService {

	@Resource
	private TicketDao ticketdao;
	

	public Film getfilmByid(String filmid) {
		
		return ticketdao.getfilmByid(filmid);
	}

	public List<Film> findSellingTicket() {
		return ticketdao.findSellingTicket();
	}

	public List<Film> findTicket() {
		return ticketdao.findTicket();
	}

}
