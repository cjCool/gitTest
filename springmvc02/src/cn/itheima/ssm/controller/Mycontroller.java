package cn.itheima.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import cn.itheima.ssm.exception.MyException;
import cn.itheima.ssm.pojo.Items;
import cn.itheima.ssm.pojo.QueryVo;
import cn.itheima.ssm.service.ItemsService;

@Controller
@RequestMapping("item")
public class Mycontroller {
	
	@Autowired
	private ItemsService service;
	
	@RequestMapping("findByAll")
	public ModelAndView  findByAll(){
		
		System.out.println("controller执行中"+new Date());
		
		List<Items> list = service.ItemsFindAll();
		
		ModelAndView model = new ModelAndView();
		model.addObject("itemList", list);
		model.setViewName("itemList");
		
		return model;
	}
	
	//查询单个
	@RequestMapping("itemEdit/{id}")
	public String itemEdit(@PathVariable() Integer id , Model model){
		
		Items items = service.itemEdit(id);
		model.addAttribute("item", items);
		
		return "editItem";
	}
	
	//修改商品
	@RequestMapping("updateitem")
	public String updateitem(Items items,MultipartFile pictureFile) throws Exception{
		
		//获取图片名称
		String name = UUID.randomUUID().toString();
		//获取后缀名
		String filename = pictureFile.getOriginalFilename();
		String houzhui = filename.substring(filename.lastIndexOf("."));
		
		//将图片放入指定盘符
		pictureFile.transferTo(new File("f:/upload/imge/"+name+houzhui));
		
		items.setPic(name+houzhui);
		service.updateitem(items);
		
		return "forward:itemEdit.action";
		
	}
	
	@RequestMapping(value = "updateAllItem")
	public String updateAllItem(QueryVo vo){
		
		System.out.println(vo);
		return "success";
		
	}
	
	@RequestMapping("findForward")
	public String findForward(HttpServletRequest request){
//		System.out.println("请求转发"+id);
		System.out.println("重定向"+request.getAttribute("id"));
		return "success";
	}
	
	@RequestMapping("findById")
	public String findById(Integer id,HttpServletRequest request,ModelMap modelMap){
		System.out.println(id);
		modelMap.put("id", id);
		//model.addAttribute("id", id);
		return "redirect:item/findForward.action";
	}
	
	@RequestMapping("queryException")
	public String queryException() throws MyException{
		
//		if(true){
//			throw new MyException("自定义异常");
//		}
		
		int i = 1/0;
		
		return "success";
		
	}
	
	@RequestMapping("findJson")
	
	public @ResponseBody Items findJson(@RequestBody Items item){
		
		System.out.println("进来");
		System.out.println(item);
		
		return item;
	}
	
}
