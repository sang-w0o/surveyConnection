package com.surveypro.member.exception;

public class MemberEmailAlreadyInUseException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 2;
	public static final String MESSAGE = "이미 사용중인 이메일입니다.";

	public MemberEmailAlreadyInUseException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
