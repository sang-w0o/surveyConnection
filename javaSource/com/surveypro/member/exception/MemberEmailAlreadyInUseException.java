package com.surveypro.member.exception;

public class MemberEmailAlreadyInUseException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 2;
	public static final String MESSAGE = "�̹� ������� �̸����Դϴ�.";

	public MemberEmailAlreadyInUseException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
