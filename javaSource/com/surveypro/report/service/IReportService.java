package com.surveypro.report.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.service.IService;

public interface IReportService extends IService {
	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
