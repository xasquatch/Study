package com.test.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AA {

	public static void main(String[] args) {
		BB bb = new BB();
		bb.aa();

	}

}

class BB {

	public void aa() {
		System.out.println("BB객체의 aa()메소드입니다.");

	}
}
