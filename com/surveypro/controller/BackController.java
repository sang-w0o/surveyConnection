package com.surveypro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BackController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
