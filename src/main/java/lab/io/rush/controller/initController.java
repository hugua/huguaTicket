package lab.io.rush.controller;

import java.util.List;

import javax.annotation.Resource;

import lab.io.rush.entity.Film;
import lab.io.rush.service.TicketService;
import lab.io.rush.util.redisUtil;

import org.springframework.beans.factory.InitializingBean;

import redis.clients.jedis.Jedis;

/**
 * 初始化类，用于项目启动时加载数据库中可预定的电影信息，并存储在redis内存数据库中
 * @author chen
 *
 */
public class initController  {

	//电影票业务层
	@Resource
	private TicketService ticketService;

	//这个方法是这个类加载时自动执行的
	public void init() throws Exception {
		System.out.println("initController");
		//创建redis，这里使用的是java的jedis
		final Jedis jedis = redisUtil.getRedis();
		//查找所有可以预定的电影票信息
		final List<Film> films = ticketService.findSellingTicket();
		//查找其中可预定的电影票
		for(Film f : films){
			jedis.set(f.getId()+"", f.getNumber()+"");
			jedis.set(f.getId()+"record","");
		}
		
		
		//这里新建一个线程来检查抢票活动是否已经结束，并做写会数据库等后续操作
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
				//写会数据库或者打印订票用户信息
			};
		}.start();
		jedis.close();
	}
	
}
