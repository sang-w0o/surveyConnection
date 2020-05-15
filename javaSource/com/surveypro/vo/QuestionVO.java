package com.surveypro.vo;

import java.util.HashMap;

public class QuestionVO {
	private int s_code;
	private int q_number;
	private String q_title;
	private String q_type;

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public int getQ_number() {
		return q_number;
	}

	public void setQ_number(int q_number) {
		this.q_number = q_number;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_type() {
		return q_type;
	}

	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + q_number;
		result = prime * result + ((q_title == null) ? 0 : q_title.hashCode());
		result = prime * result + ((q_type == null) ? 0 : q_type.hashCode());
		result = prime * result + s_code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionVO other = (QuestionVO) obj;
		if (q_number != other.q_number)
			return false;
		if (q_title == null) {
			if (other.q_title != null)
				return false;
		} else if (!q_title.equals(other.q_title))
			return false;
		if (q_type == null) {
			if (other.q_type != null)
				return false;
		} else if (!q_type.equals(other.q_type))
			return false;
		if (s_code != other.s_code)
			return false;
		return true;
	}

	public HashMap<String, Object> convertMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_code", s_code);
		map.put("q_number", q_number);
		map.put("q_title", q_title);
		map.put("q_type", q_type);
		return map;
	}
}
