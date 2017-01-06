package lab.io.rush.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;

@Component
@RequestMapping("/qqlogin.do")
public class qqloginController {

	@RequestMapping
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        
        return null;
	}
}

