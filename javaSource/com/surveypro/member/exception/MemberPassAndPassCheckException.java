package com.surveypro.member.exception;

public class MemberPassAndPassCheckException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 6;
	public static final String MESSAGE = "��й�ȣ�� ��й�ȣ Ȯ�ζ��� ��ġ���� �ʽ��ϴ�.";

	public MemberPassAndPassCheckException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
