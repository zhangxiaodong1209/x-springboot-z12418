package com.h3c.cloud.modules.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.h3c.cloud.modules.sys.dao.BaseDao;
import com.h3c.cloud.modules.user.entity.UserEntity;

/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    UserEntity queryByMobile(String mobile);
}
