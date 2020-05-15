package com.surveypro.vo;

import java.util.HashMap;

public class ReportVO {

	public ReportVO() {
	}

	private int r_id;
	private int s_code;
	private String reporter;
	private String cause;
	private String r_type;
	private String r_state;
	private String reportedWriter;

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public String getR_state() {
		return r_state;
	}

	public void setR_state(String r_state) {
		this.r_state = r_state;
	}

	public String getReportedWriter() {
		return reportedWriter;
	}

	public void setReportedWriter(String reportedWriter) {
		this.reportedWriter = reportedWriter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cause == null) ? 0 : cause.hashCode());
		result = prime * result + r_id;
		result = prime * result + ((r_state == null) ? 0 : r_state.hashCode());
		result = prime * result + ((r_type == null) ? 0 : r_type.hashCode());
		result = prime * result + ((reporter == null) ? 0 : reporter.hashCode());
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
		ReportVO other = (ReportVO) obj;
		if (cause == null) {
			if (other.cause != null)
				return false;
		} else if (!cause.equals(other.cause))
			return false;
		if (r_id != other.r_id)
			return false;
		if (r_state == null) {
			if (other.r_state != null)
				return false;
		} else if (!r_state.equals(other.r_state))
			return false;
		if (r_type == null) {
			if (other.r_type != null)
				return false;
		} else if (!r_type.equals(other.r_type))
			return false;
		if (reporter == null) {
			if (other.reporter != null)
				return false;
		} else if (!reporter.equals(other.reporter))
			return false;
		if (s_code != other.s_code)
			return false;
		return true;
	}

	public HashMap<String, Object> convertMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("r_id", r_id);
		map.put("s_code", s_code);
		map.put("reporter", reporter);
		map.put("cause", cause);
		map.put("r_type", r_type);
		map.put("r_state", r_state);
		map.put("reportedWriter", reportedWriter);
		return map;
	}
}
