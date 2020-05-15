package com.surveypro.choiceresult.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.BackController;

public interface ChoiceResultBackController extends BackController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
