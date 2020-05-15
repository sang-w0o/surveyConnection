package com.surveypro.vo;

public class AdminVO {
	private String email;
	private int reported_count;
	private int participated_count;
	private String g_name;
	private int currentPoint;
	private int addPoint;

	public AdminVO() {
		this.reported_count = 0;
		this.participated_count = 0;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReported_count() {
		return reported_count;
	}

	public void setReported_count(int reported_count) {
		this.reported_count = reported_count;
	}

	public int getParticipated_count() {
		return participated_count;
	}

	public void setParticipated_count(int participated_count) {
		this.participated_count = participated_count;
	}

	public void addReportedCount() {
		this.reported_count += 1;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}

	public int getAddPoint() {
		return addPoint;
	}

	public void setAddPoint(int addPoint) {
		this.addPoint = addPoint;
	}
}
