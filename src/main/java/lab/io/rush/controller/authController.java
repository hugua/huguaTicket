package lab.io.rush.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

@Component
@RequestMapping("/auth.do")
public class authController {
	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String code = request.getParameter("code"); 
		if(code != null && !code.isEmpty()){
			Oauth oauth = new Oauth();  
	        String token = null;
			try {
				token = oauth.getAccessTokenByCode(code).toString();
		        String str[] = token.split(","); 
		        String accessToken = str[0].split("=")[1];  
		        String str1[] = str[3].split("]");  
		        String uid = str1[0].split("=")[1]; 
		        Users users = new Users() ;	
		        users.client.setToken(accessToken) ;
		        User weiboUser = users.showUserById(uid);
		        String name = weiboUser.getScreenName();
		        request.getSession().setAttribute("user", name);	   
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		response.sendRedirect(request.getContextPath()+"/index.do");
		}else{
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		return null;  
	}
}
