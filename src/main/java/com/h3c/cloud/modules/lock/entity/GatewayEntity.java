package com.h3c.cloud.modules.lock.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Transient;

import com.h3c.cloud.common.validator.group.AddGroup;
import com.h3c.cloud.common.validator.group.UpdateGroup;


public class GatewayEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long gwId;
	
	@NotBlank(message="网关序列号不能为空", groups = {AddGroup.class, UpdateGroup.class})
	private String gwSn;
	
	
	private Long userId;
	
	@Transient
	private String token;


	/**
	 * 创建时间
	 */
	private Date createTime;
	
	
	/**
	 * 更新时间
	 */
	private Date updateTime;


	public Long getGwId() {
		return gwId;
	}


	public void setGwId(Long gwId) {
		this.gwId = gwId;
	}


	public String getGwSn() {
		return gwSn;
	}


	public void setGwSn(String gwSn) {
		this.gwSn = gwSn;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}

	
}
