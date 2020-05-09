package com.surveypro.member.exception;

public class MemberEmailNotFoundException extends MemberException {
	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 10;
	public static final String MESSAGE = "존재하지 않는 이메일 입니다.";

	public MemberEmailNotFoundException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
