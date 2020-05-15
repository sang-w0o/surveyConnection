package com.surveypro.report.exception;

public class ReportApproveException extends ReportException {

	private static final long serialVersionUID = 1L;

	private static final int ERRNO = 1;
	private static final String MESSAGE = "신고 승인 처리에 실패했습니다.";

	public ReportApproveException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
