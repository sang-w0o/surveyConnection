package com.surveypro.report.exception;

public class ReportInsertException extends ReportException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 3;
	private static final String MESSAGE = "�Ű� ����ϴµ� ������ �߻��߽��ϴ�.";

	public ReportInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
