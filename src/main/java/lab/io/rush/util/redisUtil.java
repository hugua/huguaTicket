package lab.io.rush.util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
public class redisUtil {
	private static Properties  pro;
	static{
		pro = new Properties();
		try {
			String path = redisUtil.class.getClassLoader().getResource(
					"redis.properties").getPath();
			pro.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Jedis getRedis(){
		String ip = pro.getProperty("ip");
		int port = Integer.parseInt(pro.getProperty("port"));
		Jedis jedis = new Jedis(ip, port);
		return jedis;
	}
}
