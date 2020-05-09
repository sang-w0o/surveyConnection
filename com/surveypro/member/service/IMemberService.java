package com.surveypro.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.service.IService;

public interface IMemberService extends IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
