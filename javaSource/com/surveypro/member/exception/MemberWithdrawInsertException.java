package com.surveypro.member.exception;

public class MemberWithdrawInsertException extends MemberException {

	private static final long serialVersionUID = 1L;
	private static final int ERRNO = 14;
	private static final String MESSAGE = "탈퇴 처리에 실패했습니다.";

	public MemberWithdrawInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}
