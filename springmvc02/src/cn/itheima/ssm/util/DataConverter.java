package cn.itheima.ssm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DataConverter implements Converter<String, Date> {

	public Date convert(String str) {
		try {
			Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
