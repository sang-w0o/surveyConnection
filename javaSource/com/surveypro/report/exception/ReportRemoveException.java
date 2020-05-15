package com.surveypro.report.exception;

public class ReportRemoveException extends ReportException {

	private static final long serialVersionUID = 1L;

	private static final int ERRNO = 2;
	private static final String MESSAGE = "신고 반려 처리에 실패했습니다..";

	public ReportRemoveException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
