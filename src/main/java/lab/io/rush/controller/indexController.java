package lab.io.rush.controller;

import java.util.List;

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
 * 主页控制器
 * @author chen
 *
 */
@Component
@RequestMapping("/index.do")
public class indexController {

	@Resource
	private TicketService ticketService;

	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		//查找所以的电影
		System.out.println("index.do");
		List<Film> films = ticketService.findTicket();
		Jedis jedis = redisUtil.getRedis();
		//存储可预定的电影票数
		for(Film f : films){
			if(f.getNumber()>0)
				f.setNumber(Integer.parseInt(jedis.get(f.getId()+"")));
		}
		jedis.close();
		//数据返回显示层
		ModelAndView view = new ModelAndView("index");
		view.addObject("films", films);
		return view;
	}

}
