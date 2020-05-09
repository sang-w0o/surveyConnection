package com.surveypro.member.exception;

public class MemberPassAndPassCheckException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 6;
	public static final String MESSAGE = "비밀번호와 비밀번호 확인란이 일치하지 않습니다.";

	public MemberPassAndPassCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
