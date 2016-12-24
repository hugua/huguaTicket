package lab.io.rush.service;

import java.util.List;

import javax.annotation.Resource;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Component;

import lab.io.rush.dao.TicketDao;
import lab.io.rush.entity.Film;

@Component("TicketService")
public class TicketServiceImpl implements TicketService{
	
	@Resource
	private TicketDao ticketdao;
	
	@Transactional
	public Film getfilmByid(String filmid) {
		
		return ticketdao.getfilmByid(filmid);
	}

	@Transactional
	public List<Film> findSellingTicket() {
		return ticketdao.findSellingTicket();
	}

	@Transactional
	public List<Film> findTicket() {
		return ticketdao.findTicket();
	}

}


