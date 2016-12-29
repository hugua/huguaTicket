package lab.io.rush.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import weibo4j.Oauth;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

@Component
@RequestMapping("/weibologin.do")
public class weiboLoginController {

	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Oauth oauth = new Oauth();
		String url = oauth.authorize("code",null);
		response.sendRedirect(url);
//		BareBonesBrowserLaunch.openURL(oauth.authorize("code",null));
		return null;
	}
	
}
