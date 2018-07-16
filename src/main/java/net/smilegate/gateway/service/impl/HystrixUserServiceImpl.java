package net.smilegate.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
import net.smilegate.gateway.model.USER;
import net.smilegate.gateway.service.CRUDService;
import net.smilegate.gateway.service.RESTService;

@Slf4j
@Service
public class HystrixUserServiceImpl implements CRUDService<USER> {

	@Autowired
	private RESTService<USER> restService;
		
	@HystrixCommand(fallbackMethod = "findAllFallback")
	@Override
	public List<USER> findAll() {
		log.info("hystrix");
		return restService.getList();
	}
	
	@HystrixCommand(fallbackMethod = "findOneFallback")
	@Override
	public USER findOne(int s) {
		log.info("hystrix");
		return restService.get(String.valueOf(s));
	}
	
	@HystrixCommand(fallbackMethod = "saveFallback")
	@Override
	public void save(USER t) {
		log.info("hystrix");
		restService.post(t);
	}
	
	@HystrixCommand(fallbackMethod = "updateFallback")
	@Override
	public void update(int s, USER t) {
		log.info("hystrix");
		restService.put(String.valueOf(s), t);
	}

	@HystrixCommand(fallbackMethod = "deleteFallback")
	@Override
	public void delete(int s) {
		log.info("hystrix");
		restService.delete(String.valueOf(s));
	}
	
	/**
	 * Circuit Breaker
	 */
	
	/**
	 * user 전체 조회 api call 실패 시 발동
	 * @return 
	 * 		temp userList resoures
	 */
	public List<USER> findAllFallback() {
		log.info("circuit breaker");
		return null;
	}
	
	/**
	 * user 조회 api call 실패 시 발동
	 * @param s
	 * 		user_idx
	 * @return
	 * 		temp user resources
	 */		
	public USER findOneFallback(int s) {
		log.info("circuit breaker");
		return null;
	}
	
	/**
	 * user resources 저장 api call 실패 시 발동
	 * @param t
	 * 		user resourecs
	 */
	public void saveFallback(USER t) {
		log.info("circuit breaker");
	}
	
	/**
	 * user resources 수정 api call 실패 시 발동
	 * @param s
	 * 		user_idx
	 * @param t
	 * 		user resourecs
	 */
	public void updateFallback(int s, USER t) {
		log.info("circuit breaker");
	}
	
	/**
	 * user resources 삭제 api call 실패 시 발동
	 * @param s
	 * 		user_idx
	 */
	public void deleteFallback(int s) {
		log.info("circuit breaker");
	}
	
}
