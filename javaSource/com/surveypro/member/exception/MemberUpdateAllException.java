package com.surveypro.member.exception;

public class MemberUpdateAllException extends MemberException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 17;
	private static final String MESSAGE = "회원 등급 갱신 중 오류가 발생했습니다.";

	public MemberUpdateAllException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {

	}

}
