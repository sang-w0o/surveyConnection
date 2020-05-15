package com.surveypro.vo;

public class PointHistoryVO {

	private int ph_code;
	private String email;
	private int s_code;
	private int pointchange;
	private String ph_type;

	public PointHistoryVO() {

	}

	public int getPh_code() {
		return ph_code;
	}

	public void setPh_code(int ph_code) {
		this.ph_code = ph_code;
	}

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

	public int getPointchange() {
		return pointchange;
	}

	public void setPointchange(int pointchange) {
		this.pointchange = pointchange;
	}

	public String getPh_type() {
		return ph_type;
	}

	public void setPh_type(String ph_type) {
		this.ph_type = ph_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ph_code;
		result = prime * result + ((ph_type == null) ? 0 : ph_type.hashCode());
		result = prime * result + pointchange;
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
		PointHistoryVO other = (PointHistoryVO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ph_code != other.ph_code)
			return false;
		if (ph_type == null) {
			if (other.ph_type != null)
				return false;
		} else if (!ph_type.equals(other.ph_type))
			return false;
		if (pointchange != other.pointchange)
			return false;
		if (s_code != other.s_code)
			return false;
		return true;
	}

}
