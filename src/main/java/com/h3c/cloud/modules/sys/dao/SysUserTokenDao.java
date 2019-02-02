package com.h3c.cloud.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.h3c.cloud.modules.sys.entity.SysUserTokenEntity;

/**
 * 系统用户Token
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {
    
    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);
	
}
