package com.surveypro.member.exception;

import com.surveypro.member.exception.MemberException;

public class MemberPassEmptyException extends MemberException {

	private static final long serialVersionUID = 1L;
	public static final int ERRNO = 8;
	public static final String MESSAGE = "��й�ȣ �Է¶��� ������ϴ�.";

	public MemberPassEmptyException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
