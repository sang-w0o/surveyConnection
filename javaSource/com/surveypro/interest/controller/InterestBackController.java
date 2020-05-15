package com.surveypro.interest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.BackController;

public interface InterestBackController extends BackController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
