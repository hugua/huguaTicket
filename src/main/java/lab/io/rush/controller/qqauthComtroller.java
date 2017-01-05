package lab.io.rush.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

@Component
@RequestMapping("/qqauth.do")
public class qqauthComtroller {
	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		  try {
		        AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
		        String accessToken   = null,
		               openID        = null;
		        long tokenExpireIn = 0L;
		        if (accessTokenObj.getAccessToken().equals("")) {
		            System.out.print("没有获取到响应参数");
		        }else{
		        	accessToken = accessTokenObj.getAccessToken();
	                tokenExpireIn = accessTokenObj.getExpireIn();
	                OpenID openIDObj =  new OpenID(accessToken);
	                openID = openIDObj.getUserOpenID();
	                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
	                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
	                String name = userInfoBean.getNickname();
	                request.getSession().setAttribute("user", name);	
	                response.sendRedirect(request.getContextPath()+"/index.do");
		        }
		    
			}catch(Exception e){
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		
	return null;
	}
}
