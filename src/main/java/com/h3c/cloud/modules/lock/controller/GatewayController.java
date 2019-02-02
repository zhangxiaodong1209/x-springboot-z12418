package com.h3c.cloud.modules.lock.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.h3c.cloud.common.annotation.SysLog;
import com.h3c.cloud.common.utils.PageUtils;
import com.h3c.cloud.common.utils.Query;
import com.h3c.cloud.common.utils.R;
import com.h3c.cloud.modules.lock.entity.GatewayEntity;
import com.h3c.cloud.modules.lock.service.GatewayService;



@RestController
@RequestMapping("/gateway")
public class GatewayController {
	
	@Autowired
	private GatewayService gatewayService;
	
	@Resource
	private HttpServletRequest request;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("lock:gateway:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String token = request.getHeader("token");
        Query query = new Query(params);
		query.isPaging(true);
		query.put("token", token);
		List<GatewayEntity> gatewayList = gatewayService.queryList(query);
		PageUtils pageUtil = new PageUtils(gatewayList, query.getTotle(), query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{gwId}")
	@RequiresPermissions("lock:gateway:info")
	public R info(@PathVariable("gwId") Long gwId){
		GatewayEntity gateway = gatewayService.queryObject(gwId);
		
		return R.ok().put("gateway", gateway);
	}
	
	
	/**
	 * 保存
	 */
	@SysLog("添加设备")
	@RequestMapping("/save")
	@RequiresPermissions("lock:gateway:save")
	public R save(@RequestBody GatewayEntity gateway){
		String token = request.getHeader("token");
		gateway.setToken(token);
		gatewayService.save(gateway);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("更新设备")
	@RequestMapping("/update")
	@RequiresPermissions("lock:gateway:update")
	public R update(@RequestBody GatewayEntity gateway){
		gatewayService.update(gateway);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除设备")
	@RequestMapping("/delete")
	@RequiresPermissions("lock:gateway:delete")
	public R delete(@RequestBody Long[] gwIds){
		gatewayService.deleteBatch(gwIds);
		
		return R.ok();
	}
}
