package com.test.aop2;

public class ServiceImpl implements Service {

	@Override
	public void getBoard() {
		System.out.println("getBoard 호출");
	}

	@Override
	public void addBoard() {
		System.out.println("addBoard 호출");

	}

	@Override
	public void delBoard() {
		System.out.println("delBoard 호출");

	}

}
