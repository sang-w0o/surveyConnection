package com.surveypro.member.exception;

public class MemberWithdrawLoginException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 11;
	public static final String MESSAGE = "Ż�� ȸ���� �α��� �� �� �����ϴ�.";

	public MemberWithdrawLoginException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
