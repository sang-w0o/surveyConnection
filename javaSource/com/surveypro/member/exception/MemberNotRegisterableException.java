package com.surveypro.member.exception;

public class MemberNotRegisterableException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 7;
	public static final String MESSAGE = "탈퇴한 후로부터 30일이 지나지 않아 재가입이 불가능한 이메일 입니다.";

	public MemberNotRegisterableException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
