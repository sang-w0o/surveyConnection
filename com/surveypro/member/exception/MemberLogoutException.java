package com.surveypro.member.exception;

public class MemberLogoutException extends MemberException {
	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 12;
	public static final String MESSAGE = "�α׾ƿ� ó���� �����߽��ϴ�.";

	public MemberLogoutException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
