package ch09.exception;

import java.io.IOException;

class Parent{
	void methodA() throws IOException{}
	void methodB() throws ClassNotFoundException{}
}

public class OverridingTest extends Parent {
	
	
	
	@Override
	void methodA() throws IOException {
	}

	@Override
	void methodB() throws ClassNotFoundException {
	}

	public static void main(String[] args) {
	
	}

}
