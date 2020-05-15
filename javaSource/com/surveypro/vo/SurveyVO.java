package com.surveypro.vo;

import java.util.HashMap;

public class SurveyVO {

	public SurveyVO() {

	}

	private int s_code;

	private String email;
	private int s_id;
	private String c_code;
	private String s_public;
	private int price;
	private String written_date;
	private String s_title;
	

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getS_public() {
		return s_public;
	}

	public void setS_public(String s_public) {
		this.s_public = s_public;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getWritten_date() {
		return written_date;
	}

	public void setWritten_date(String written_date) {
		this.written_date = written_date;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_code == null) ? 0 : c_code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + price;
		result = prime * result + s_code;
		result = prime * result + s_id;
		result = prime * result + ((s_public == null) ? 0 : s_public.hashCode());
		result = prime * result + ((s_title == null) ? 0 : s_title.hashCode());
		result = prime * result + ((written_date == null) ? 0 : written_date.hashCode());
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
		SurveyVO other = (SurveyVO) obj;
		if (c_code == null) {
			if (other.c_code != null)
				return false;
		} else if (!c_code.equals(other.c_code))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (price != other.price)
			return false;
		if (s_code != other.s_code)
			return false;
		if (s_id != other.s_id)
			return false;
		if (s_public == null) {
			if (other.s_public != null)
				return false;
		} else if (!s_public.equals(other.s_public))
			return false;
		if (s_title == null) {
			if (other.s_title != null)
				return false;
		} else if (!s_title.equals(other.s_title))
			return false;
		if (written_date == null) {
			if (other.written_date != null)
				return false;
		} else if (!written_date.equals(other.written_date))
			return false;
		return true;
	}

	public HashMap<String, Object> convertMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_code", s_code);
		map.put("email", email);
		map.put("s_id", s_id);
		map.put("c_code", c_code);
		map.put("s_public", s_public);
		map.put("price", price);
		map.put("written_date", written_date);
		map.put("s_title", s_title);
		return map;
	}

}
