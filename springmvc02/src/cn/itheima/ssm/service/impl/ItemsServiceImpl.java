package cn.itheima.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itheima.ssm.mapper.ItemsMapper;
import cn.itheima.ssm.pojo.Items;
import cn.itheima.ssm.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper mapper;
	
	public List<Items> ItemsFindAll() {
		List<Items> list = mapper.selectByExample(null);
		return list;
	}

	public Items itemEdit(Integer id) {
		Items items = mapper.selectByPrimaryKey(id);
		return items;
	}

	public void updateitem(Items items) {
		mapper.updateByPrimaryKey(items);
	}
	
}
