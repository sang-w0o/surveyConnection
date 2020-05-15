package com.surveypro.vo;

import java.util.HashMap;

public class ChoiceResultVO {

	public ChoiceResultVO() {

	}

	private int s_code;
	private int q_number;
	private int choice_num;
	private String respondent;

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

	public int getChoice_num() {
		return choice_num;
	}

	public void setChoice_num(int choice_num) {
		this.choice_num = choice_num;
	}

	public String getRespondent() {
		return respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + choice_num;
		result = prime * result + q_number;
		result = prime * result + ((respondent == null) ? 0 : respondent.hashCode());
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
		ChoiceResultVO other = (ChoiceResultVO) obj;
		if (choice_num != other.choice_num)
			return false;
		if (q_number != other.q_number)
			return false;
		if (respondent == null) {
			if (other.respondent != null)
				return false;
		} else if (!respondent.equals(other.respondent))
			return false;
		if (s_code != other.s_code)
			return false;
		return true;
	}

	public HashMap<String, Object> convertMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("s_code", s_code);
		map.put("q_number", q_number);
		map.put("choice_num", choice_num);
		map.put("respondent", respondent);

		return map;
	}

}
