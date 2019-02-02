package com.h3c.cloud.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.h3c.cloud.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-08 10:40:56
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
