package com.h3c.cloud.modules.lock.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.cloud.modules.lock.dao.GatewayDao;
import com.h3c.cloud.modules.lock.entity.GatewayEntity;
import com.h3c.cloud.modules.lock.service.GatewayService;
import com.h3c.cloud.modules.sys.dao.SysUserTokenDao;
import com.h3c.cloud.modules.sys.entity.SysUserTokenEntity;



@Service("gatewayService")
public class GatewayServiceImpl implements GatewayService {
	@Autowired
	private GatewayDao gatewayDao;
	
	@Autowired
	private SysUserTokenDao sysUserTokenDao;
	
	@Override
	public GatewayEntity queryObject(Long gwId){
		return gatewayDao.queryObject(gwId);
	}
	
	@Override
	public List<GatewayEntity> queryList(Map<String, Object> map){
		String token = (String) map.get("token");
		SysUserTokenEntity userToken = sysUserTokenDao.queryByToken(token);
		map.remove("token");
		map.put("userId", userToken.getUserId());
		return gatewayDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return gatewayDao.queryTotal(map);
	}

	@Override
	public void save(GatewayEntity gatewayEntity){
		gatewayEntity.setCreateTime(new Date());
		gatewayEntity.setUpdateTime(new Date());
		SysUserTokenEntity userToken = sysUserTokenDao.queryByToken(gatewayEntity.getToken());
		gatewayEntity.setUserId(userToken.getUserId());
		gatewayDao.save(gatewayEntity);
	}


	@Override
	public void update(GatewayEntity gatewayEntity){
		gatewayEntity.setUpdateTime(new Date());
		gatewayDao.update(gatewayEntity);
	}
	
	@Override
	public void delete(Long gwId){
		gatewayDao.delete(gwId);
	}
	
	@Override
	public void deleteBatch(Long[] gwIds){
		gatewayDao.deleteBatch(gwIds);
	}
}
