package com.surveypro.vo;

import java.util.HashMap;

public class SurveyInfoVO {
	private int s_code;
	private String writer;
	private String s_title;
	private int interest_count;
	private String written_date;
	private String end_date;
	private String spare_sample_num;
	private int price;
	private String respondent;
	private String c_desc;
	private String email;

	public String getRespondent() {
		return respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getS_title() {
		return s_title;
	}

	public void setS_title(String s_title) {
		this.s_title = s_title;
	}

	public int getInterest_count() {
		return interest_count;
	}

	public void setInterest_count(int interest_count) {
		this.interest_count = interest_count;
	}

	public String getWritten_date() {
		return written_date;
	}

	public void setWritten_date(String written_date) {
		this.written_date = written_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getSpare_sample_num() {
		return spare_sample_num;
	}

	public void setSpare_sample_num(String spare_sample_num) {
		this.spare_sample_num = spare_sample_num;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + interest_count;
		result = prime * result + price;
		result = prime * result + ((respondent == null) ? 0 : respondent.hashCode());
		result = prime * result + s_code;
		result = prime * result + ((s_title == null) ? 0 : s_title.hashCode());
		result = prime * result + ((spare_sample_num == null) ? 0 : spare_sample_num.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		SurveyInfoVO other = (SurveyInfoVO) obj;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (interest_count != other.interest_count)
			return false;
		if (price != other.price)
			return false;
		if (respondent == null) {
			if (other.respondent != null)
				return false;
		} else if (!respondent.equals(other.respondent))
			return false;
		if (s_code != other.s_code)
			return false;
		if (s_title == null) {
			if (other.s_title != null)
				return false;
		} else if (!s_title.equals(other.s_title))
			return false;
		if (spare_sample_num == null) {
			if (other.spare_sample_num != null)
				return false;
		} else if (!spare_sample_num.equals(other.spare_sample_num))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
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
		map.put("writer", writer);
		map.put("s_title", s_title);
		map.put("interest_count", interest_count);
		map.put("written_date", written_date);
		map.put("end_date", end_date);
		map.put("spare_sample_num", spare_sample_num);
		map.put("price", price);
		map.put("respondent", respondent);
		map.put("c_desc", c_desc);
		map.put("email", email);
		return map;
	}

	public String getC_desc() {
		return c_desc;
	}

	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
