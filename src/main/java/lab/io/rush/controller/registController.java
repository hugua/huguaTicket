package lab.io.rush.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import lab.io.rush.service.UserService;

/**
 * 用户注册控制器
 * @author chen
 *
 */
@Component
@RequestMapping("/regist.do")
public class registController {

	@Resource
	private UserService userService;

	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("regist.do");
		String mail = request.getParameter("mail");	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int num = userService.regist(mail,username,password);
		ModelAndView view = new ModelAndView("login");
		if(num == 1){
			String msg = "注册成功，请登录";
			view.addObject("msg",msg);
		}else{
			String msg = "用户已存在";
			view.addObject("msg",msg);
		}	
		return view;
	}

}
