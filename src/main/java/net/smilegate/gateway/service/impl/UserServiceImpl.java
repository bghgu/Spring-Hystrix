package net.smilegate.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.smilegate.gateway.controller.UserController;
import net.smilegate.gateway.model.USER;
import net.smilegate.gateway.service.CRUDService;
import net.smilegate.gateway.service.RESTService;

@Slf4j
@Service
public class UserServiceImpl implements CRUDService<USER> {
	
	@Autowired
	private RESTService<USER> restService;
	
	@Override
	public List<USER> findAll() {
		return restService.getList();
	}

	@Override
	public USER findOne(int s) {
		return restService.get(String.valueOf(s));
	}

	@Override
	public void save(USER t) {
		restService.post(t);
	}

	@Override
	public void update(int s, USER t) {
		restService.put(String.valueOf(s), t);
	}

	@Override
	public void delete(int s) {
		restService.delete(String.valueOf(s));
	}	

}
