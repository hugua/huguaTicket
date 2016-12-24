package lab.io.rush.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import redis.clients.jedis.Jedis;

/**
 * 定时刷新控制器，用来实时刷新剩余票数
 * @author chen
 *
 */
@Component
@RequestMapping("/refresh.do")
public class refreshController {

	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("refresh.do");
		String filmid = request.getParameter("id");
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		int number = Integer.parseInt(jedis.get(filmid));
		response.getWriter().write(number+"");
		jedis.close();
		return null;
	}

}