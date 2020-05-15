package com.surveypro.vo;

import java.util.HashMap;

public class ChoiceVO {

	private int s_code;
	private int q_number;
	private int choice_num;
	private String choice_content;

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

	public String getChoice_content() {
		return choice_content;
	}

	public void setChoice_content(String choice_content) {
		this.choice_content = choice_content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choice_content == null) ? 0 : choice_content.hashCode());
		result = prime * result + choice_num;
		result = prime * result + q_number;
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
		ChoiceVO other = (ChoiceVO) obj;
		if (choice_content == null) {
			if (other.choice_content != null)
				return false;
		} else if (!choice_content.equals(other.choice_content))
			return false;
		if (choice_num != other.choice_num)
			return false;
		if (q_number != other.q_number)
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
		map.put("choice_content", choice_content);
		return map;
	}

}
