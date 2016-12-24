package lab.io.rush.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.io.rush.Service.UserService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

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
		String msg = userService.regist(mail,username,password);
		ModelAndView view = new ModelAndView("login");
		view.addObject("msg",msg);
		return view;
	}

}
