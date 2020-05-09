package com.surveypro.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.BackController;

public interface MemberBackController extends BackController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
