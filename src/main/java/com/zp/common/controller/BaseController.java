package com.zp.common.controller;

import org.springframework.stereotype.Controller;

import com.zp.common.utils.ShiroUtils;
import com.zp.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}