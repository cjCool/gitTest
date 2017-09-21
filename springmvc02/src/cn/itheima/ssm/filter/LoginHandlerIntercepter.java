package cn.itheima.ssm.filter;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itheima.ssm.mapper.UserMapper;

public class LoginHandlerIntercepter implements HandlerInterceptor {
	
	//返回视图后
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("返回视图后"+new Date());
		
	}
	
	
	//执行完controller返回视图之前
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("执行完controller返回视图之前"+new Date());
	}
	
	//执行controller前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("执行controller前"+new Date());
		
		//判断session中是否有账号密码
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		if(username==null){
			//跳转到登录页面.从方法中进去
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		//调取
		return true;
	}

}
