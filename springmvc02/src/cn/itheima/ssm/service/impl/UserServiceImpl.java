package cn.itheima.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itheima.ssm.mapper.UserMapper;
import cn.itheima.ssm.pojo.User;
import cn.itheima.ssm.pojo.UserExample;
import cn.itheima.ssm.pojo.UserExample.Criteria;
import cn.itheima.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User findByUsernameAndPassword(User user) {
		
		User u = userMapper.findByUsername(user);
		return u;
	}
	
}
