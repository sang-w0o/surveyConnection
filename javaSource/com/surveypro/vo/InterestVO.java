package com.surveypro.vo;

import java.util.HashMap;

public class InterestVO {

	public InterestVO() {

	}

	private String email;
	private int s_code;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		InterestVO other = (InterestVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (s_code != other.s_code)
			return false;
		return true;
	}

	public HashMap<String, Object> convertMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("s_code", s_code);
		return map;
	}

}
