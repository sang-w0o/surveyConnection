package com.surveypro.report.exception;

public class ReportInsertException extends ReportException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 3;
	private static final String MESSAGE = "신고를 등록하는데 오류가 발생했습니다.";

	public ReportInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
