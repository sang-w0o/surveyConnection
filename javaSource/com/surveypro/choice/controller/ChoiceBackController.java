package com.surveypro.choice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.BackController;

public interface ChoiceBackController extends BackController {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
