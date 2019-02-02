package com.h3c.cloud.modules.sys.service;

import com.h3c.cloud.common.utils.R;
import com.h3c.cloud.modules.sys.entity.SysUserEntity;
import com.h3c.cloud.modules.sys.entity.SysUserTokenEntity;
import com.h3c.cloud.modules.sys.model.LoginUser;

/**
 * 用户Token
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	void save(SysUserTokenEntity token);
	
	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);
	
	R createToken(SysUserEntity user,LoginUser loginUser);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
