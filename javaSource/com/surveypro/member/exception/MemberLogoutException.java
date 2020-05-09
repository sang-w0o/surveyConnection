package com.surveypro.member.exception;

public class MemberLogoutException extends MemberException {
	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 12;
	public static final String MESSAGE = "로그아웃 처리에 실패했습니다.";

	public MemberLogoutException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
