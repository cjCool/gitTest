package cn.itheima.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ItemHandlerException implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception exception) {
		String message;
		if(exception instanceof MyException){
			//标示预期异常
			MyException ex= (MyException) exception;
			message = ex.getMessage();
		}else{
			//表示系统异常
			//给开发人员发邮箱或者短信
			//获取异常信息
			message = "系统繁忙";
			exception.printStackTrace();
		}
		
		ModelAndView model = new ModelAndView();
		model.addObject("message", message);
		model.setViewName("error");
		
		return model;
	}

}
