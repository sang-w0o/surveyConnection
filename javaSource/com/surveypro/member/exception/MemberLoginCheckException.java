package com.surveypro.member.exception;

public class MemberLoginCheckException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 15;
	public static final String MESSAGE = "로그인을 먼저 해주세요.";

	public MemberLoginCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
