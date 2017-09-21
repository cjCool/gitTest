package cn.itheima.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itheima.ssm.pojo.User;
import cn.itheima.ssm.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("login")
	public String Login(){
		//跳到
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("findByUsernameAndPassword")
	@ResponseBody
	public Map<String, Object> findByUsernameAndPassword(@RequestBody User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		User u = service.findByUsernameAndPassword(user);
		
		if(u!=null){
			//放入账号密码session
			HttpSession session = request.getSession();
			session.setAttribute("username", u.getUsername());
			//跳转到
			map.put("message", "成功");
			map.put("success", true);
		}else{
			map.put("message", "账号或密码错误");
			map.put("success", false);
		}
		//没有查询出来跳转
		
		return map;
	}
}
