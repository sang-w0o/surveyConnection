package com.surveypro.member.exception;

public class MemberUpdateAllException extends MemberException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 17;
	private static final String MESSAGE = "ȸ�� ��� ���� �� ������ �߻��߽��ϴ�.";

	public MemberUpdateAllException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {

	}

}
