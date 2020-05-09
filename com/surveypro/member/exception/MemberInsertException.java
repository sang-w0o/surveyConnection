package com.surveypro.member.exception;

public class MemberInsertException extends MemberException {

	private static final long serialVersionUID = 1L;

	public static final int ERRNO = 1;
	public static final String MESSAGE = "회원가입 중 오류 발생";

	public MemberInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
