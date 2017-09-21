package cn.itheima.ssm.service;

import cn.itheima.ssm.pojo.User;

public interface UserService {

	User findByUsernameAndPassword(User user);

}
