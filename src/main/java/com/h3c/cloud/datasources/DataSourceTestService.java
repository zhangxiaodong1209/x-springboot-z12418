package com.h3c.cloud.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h3c.cloud.datasources.annotation.DataSource;
import com.h3c.cloud.modules.user.entity.UserEntity;
import com.h3c.cloud.modules.user.service.UserService;

/**
 * 测试
 * @author czx
 * @email object_czx@163.com
 * @date 2017/9/16 23:10
 */
@Service
public class DataSourceTestService implements DataSourceTestInterface{

    @Autowired
    private UserService userService;

    @Override
    public UserEntity queryObject(Long userId){
        return userService.queryObject(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    @Override
    public UserEntity queryObject2(Long userId){
        return userService.queryObject(userId);
    }
}
