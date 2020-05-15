package com.surveypro.vo;

import java.util.HashMap;

public class SubjectiveResultVO {
	private int s_code;
	private int q_number;
	private String respondent;
	private String answer;

	public SubjectiveResultVO() {

	}

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

	public String getRespondent() {
		return respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
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
		SubjectiveResultVO other = (SubjectiveResultVO) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
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
		map.put("respondent", respondent);
		map.put("answer", answer);
		return map;
	}
}
