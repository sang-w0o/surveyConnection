package com.surveypro.member.exception;

public class MemberLoginCheckException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 15;
	public static final String MESSAGE = "�α����� ���� ���ּ���.";

	public MemberLoginCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
