package com.surveypro.member.exception;

public class MemberAdminAccessException extends MemberException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 16;
	private static final String MESSAGE = "잘못된 접근 또는 요청입니다.";

	public MemberAdminAccessException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
