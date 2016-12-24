package lab.io.rush.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.io.rush.Entity.Film;
import lab.io.rush.Service.TicketService;
import lab.io.rush.Service.UserService;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
@RequestMapping("/login.do")
public class loginController{

	@Resource
	private UserService userservice; 
	
	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("login.do");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg = null;
		Film film = new Film();
		if(userservice.login(username,password)==1){
			System.out.println("登陆成功");
			request.getSession().setAttribute("user", username);
			response.sendRedirect("index.do");
			return null;
		}else{
			System.out.println("登陆失败");
			msg = "登陆失败";
			ModelAndView view = new ModelAndView();
			view.addObject("msg", msg);
			return view;
		}	
	}
}
