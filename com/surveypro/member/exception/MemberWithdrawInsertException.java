package com.surveypro.member.exception;

public class MemberWithdrawInsertException extends MemberException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 14;
	private static final String MESSAGE = "Ż�� ó���� �����߽��ϴ�.";

	public MemberWithdrawInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
