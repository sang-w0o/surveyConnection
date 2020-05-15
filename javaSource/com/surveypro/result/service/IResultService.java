package com.surveypro.result.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.service.IService;

public interface IResultService extends IService{
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
