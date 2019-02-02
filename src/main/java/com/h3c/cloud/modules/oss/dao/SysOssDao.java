package com.h3c.cloud.modules.oss.dao;

import org.apache.ibatis.annotations.Mapper;

import com.h3c.cloud.modules.oss.entity.SysOssEntity;
import com.h3c.cloud.modules.sys.dao.BaseDao;

/**
 * 文件上传
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-03-25 12:13:26
 */
@Mapper
public interface SysOssDao extends BaseDao<SysOssEntity> {
	
}
