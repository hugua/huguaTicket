package lab.io.rush.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.io.rush.entity.Film;
import lab.io.rush.service.TicketService;
import lab.io.rush.util.redisUtil;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import redis.clients.jedis.Jedis;

/**
 * 电影详情控制器
 * @author chen
 *
 */
@Component
@RequestMapping("/preview.do")
public class previewController{

	@Resource
	private TicketService ticketService;
	
	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String filmid = request.getParameter("filmid");
		Film film = ticketService.getfilmByid(filmid);
		ModelAndView view = new ModelAndView("preview");
		Jedis jedis = redisUtil.getRedis();
		film.setNumber(Integer.parseInt(jedis.get(film.getId()+"")));
		jedis.close();
		view.addObject("film", film);
		return view;
	}

}
