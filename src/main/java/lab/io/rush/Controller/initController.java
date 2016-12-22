package lab.io.rush.Controller;

import java.util.List;

import javax.annotation.Resource;

import lab.io.rush.Entity.Film;
import lab.io.rush.Service.TicketService;
import lab.io.rush.Service.User2TicketService;

import org.springframework.beans.factory.InitializingBean;

import redis.clients.jedis.Jedis;

public class initController implements InitializingBean {

	@Resource
	private TicketService ticketService;
	@Resource
	private User2TicketService user2TicketService;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initController");
		final Jedis jedis = new Jedis("127.0.0.1", 6379);
		final List<Film> films = ticketService.findSellingTicket();
		for(Film f : films){
			jedis.set(f.getId()+"", f.getNumber()+"");
			jedis.set(f.getId()+"record","");
		}
		System.out.println(films.size());
		new Thread(){
			public void run() {
				int flag = 1;
				while(flag == 1){
					for(Film f : films){
							if(Integer.parseInt(jedis.get(f.getId()+"")) == 0){
								String record = jedis.get(f.getId()+"record");
								System.out.println(record);
								flag = 0;
						}
					}
				}
			};
		}.start();
		jedis.close();
	}
	
}
