package com.test.aop2;

public class ServiceImpl implements Service {

	@Override
	public void getBoard() {
		System.out.println("getBoard ȣ��");
	}

	@Override
	public void addBoard() {
		System.out.println("addBoard ȣ��");

	}

	@Override
	public void delBoard() {
		System.out.println("delBoard ȣ��");

	}

}
