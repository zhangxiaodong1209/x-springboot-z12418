package com.h3c.cloud.modules.lock.dao;

import org.apache.ibatis.annotations.Mapper;

import com.h3c.cloud.modules.lock.entity.GatewayEntity;
import com.h3c.cloud.modules.sys.dao.BaseDao;

@Mapper
public interface GatewayDao extends BaseDao<GatewayEntity> {
	
	
}
