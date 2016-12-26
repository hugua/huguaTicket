package lab.io.rush.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Component;

import lab.io.rush.entity.Film;

/**
 * 用户类数据库接口层
 * @author chen
 *
 */
public interface TicketDao {

	/**
	 * 根据id查找电影
	 * @param filmid  电影id
	 * @return 返回电影对象
	 */
	public Film getfilmByid(String filmid);
	/**
	 * 查找可预定的电影信息
	 * @return 返回电影对象列表
	 */
	public List<Film> findSellingTicket();

	/**
	 * 查找所有的电影信息
	 * @return 返回电影对象列表
	 */
	public List<Film> findTicket();
}
