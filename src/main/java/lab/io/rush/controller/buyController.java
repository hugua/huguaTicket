package lab.io.rush.controller;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.io.rush.entity.User;
import lab.io.rush.service.UserService;
import lab.io.rush.util.Mymail;
import lab.io.rush.util.redisUtil;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import redis.clients.jedis.Jedis;

/**
 * 用户购票控制器
 * @author chen
 *
 */
@Component
@RequestMapping("/buy.do")
public class buyController  {

	@Resource
	private UserService userService;
	
	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("buy.do");
		//创建redis对象
		Jedis jedis = redisUtil.getRedis();
		String filmid = request.getParameter("id");
		final String filmname = request.getParameter("filmname");
		int number = Integer.parseInt(jedis.get(filmid));
		final String username = (String)request.getSession().getAttribute("user");
		//判断是否还有余量，并判断用户是否已经订票了
		if(number > 0){
			String record = jedis.get(filmid+"record");
			if(record == null || record.isEmpty() || !(record.contains(username))){
				record = record +";" +username;
				jedis.set(filmid, (number-1)+"");
				jedis.set(filmid+"record", record);
				 
				//因为发送邮件需要比较长的时间，这里新建一个线程
				 new Thread(){
					public void run() {
						try {
							User user = userService.findUserByname(username);
							String content = "亲爱的" + username +"恭喜你，成功购买电影票《"+filmname+"》，请准时观看！";
							if(user.getMail()!= null){
								Mymail mail = new Mymail("电影票抢购成功",content,user.getMail());
								mail.send();
							}
							
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					};
				}.start();
				response.getWriter().write("购买成功");
			}else{
				response.getWriter().write("您已经购买了电影票，不能重新购买");
			}
		}else{
			response.getWriter().write("不好意思，电影票已经售空！");
		}
		
		jedis.close();
		return null;
	}

}
