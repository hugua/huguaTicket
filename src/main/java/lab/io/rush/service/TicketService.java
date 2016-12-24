package lab.io.rush.service;

import java.util.List;

import javax.annotation.Resource;
import javax.jdo.annotations.Transactional;

import org.springframework.stereotype.Component;

import lab.io.rush.dao.TicketDao;
import lab.io.rush.entity.Film;

/**
 * 电影票业务层接口
 * @author chen
 *
 */
public interface TicketService {

	/**
	 * 根据id查找电影
	 * @param filmid  电影id
	 * @return 返回电影对象
	 */
	public Film getfilmByid(String filmid) ;

	/**
	 * 查找可预定的电影信息
	 * @return 返回电影对象列表
	 */
	public List<Film> findSellingTicket() ;

	/**
	 * 查找所有的电影信息
	 * @return 返回电影对象列表
	 */
	public List<Film> findTicket() ;

}
