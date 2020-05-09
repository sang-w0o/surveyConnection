package com.surveypro.survey.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.surveypro.controller.BackController;

public interface SurveyBackController extends BackController {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
