package lab.io.rush.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.io.rush.Entity.Film;
import lab.io.rush.Service.TicketService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import redis.clients.jedis.Jedis;

@Component
@RequestMapping("/index.do")
public class indexController {

	@Resource
	private TicketService ticketService;

	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("index.do");
		List<Film> films = ticketService.findTicket();
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		for(Film f : films){
			if(f.getNumber()>0)
				f.setNumber(Integer.parseInt(jedis.get(f.getId()+"")));
		}
		jedis.close();
		ModelAndView view = new ModelAndView("index");
		view.addObject("films", films);
		return view;
	}

}
