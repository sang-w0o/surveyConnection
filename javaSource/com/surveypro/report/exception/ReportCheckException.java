package com.surveypro.report.exception;

public class ReportCheckException extends ReportException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 4;
	private static final String MESSAGE = "한번 신고한 설문은 다시 신고할 수 없습니다.";

	public ReportCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
