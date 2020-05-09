package com.surveypro.member.exception;

public class MemberNickAlreadyInUseException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 3;
	public static final String MESSAGE = "이미 사용 중인 별명입니다.";

	public MemberNickAlreadyInUseException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
