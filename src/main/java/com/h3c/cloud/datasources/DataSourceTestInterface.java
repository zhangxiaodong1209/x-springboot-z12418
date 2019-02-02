package com.h3c.cloud.datasources;

import com.h3c.cloud.modules.user.entity.UserEntity;

/**
 * Created by czx on 2018/3/15.
 */
public interface DataSourceTestInterface {

    UserEntity queryObject(Long userId);

    UserEntity queryObject2(Long userId);
}
