package com.surveypro.interest.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.service.IService;

public interface IInterestService extends IService {
	public void doService(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
