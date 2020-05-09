package com.surveypro.vo;

import java.util.HashMap;

public class CategoryVO {
	private String c_code;
	private String c_desc;

	public CategoryVO() {

	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_desc() {
		return c_desc;
	}

	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_code == null) ? 0 : c_code.hashCode());
		result = prime * result + ((c_desc == null) ? 0 : c_desc.hashCode());
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
		CategoryVO other = (CategoryVO) obj;
		if (c_code == null) {
			if (other.c_code != null)
				return false;
		} else if (!c_code.equals(other.c_code))
			return false;
		if (c_desc == null) {
			if (other.c_desc != null)
				return false;
		} else if (!c_desc.equals(other.c_desc))
			return false;
		return true;
	}

	public HashMap<String, Object> convertMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("c_code", c_code);
		map.put("c_desc", c_desc);
		return map;
	}
}
