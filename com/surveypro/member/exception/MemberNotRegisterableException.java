package com.surveypro.member.exception;

public class MemberNotRegisterableException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 7;
	public static final String MESSAGE = "Ż���� �ķκ��� 30���� ������ �ʾ� �簡���� �Ұ����� �̸��� �Դϴ�.";

	public MemberNotRegisterableException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}
}
