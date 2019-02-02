package com.h3c.cloud.modules.lock.service;

import java.util.List;
import java.util.Map;

import com.h3c.cloud.modules.lock.entity.GatewayEntity;


public interface GatewayService {
	
	GatewayEntity queryObject(Long gwId);
	
	List<GatewayEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GatewayEntity userEntity);

	void update(GatewayEntity user);
	
	void delete(Long gwId);
	
	void deleteBatch(Long[] gwIds);
}
