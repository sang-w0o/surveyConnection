package com.surveypro.pointhistory.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.service.IService;

public interface IPointHistoryService extends IService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
