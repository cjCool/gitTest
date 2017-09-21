package cn.itheima.ssm.service;

import java.util.List;

import cn.itheima.ssm.pojo.Items;

public interface ItemsService {
	
	public List<Items> ItemsFindAll();

	public Items itemEdit(Integer id);

	public void updateitem(Items items);
	
}
