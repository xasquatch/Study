package com.test.spring;

/*기존에 자바에서 사용 했던  DI 의존 방식 예제*/
public class AA {
	public static void main(String[] args) {
		//개발자가 직접 수동으로 객체 생성
		//AA클래스 내부에서 BB클래스에 대한 객체 생성
		BB bb = new BB();
		bb.aa();//AA클래스 내부에서 BB객체의 aa()메소드 사용 
	}
}
class BB{
	public void aa() {
		System.out.println("BB객체의 aa()메소드 입니다.");
	}	
}
//결론 : 
//AA객체는 BB객체의 aa()라는 메소드를 사용 하고 있기 떄문에...
//AA는 BB에 의존한다. (AA has a BB)라고 할수 있다.
//문제점 -> 만약 BB객체에 aa()메소드 이름이 변경되거나 내용이 수정되었다면!
//AA객체에서 기존 수정전으로 출력문!("BB객체의 aa()메소드 입니다.")
//을 더이상 사용할 수 없는 문제점이 생기게 됨.
//즉! BB객체의 수정에 따라 AA객체에서 출력한 결과가 좌우되는 종속성의
//문제를 가질수 있다.

//AA객체가 BB객체를 의존할때 종속성의 문제를 해결 하려면
//AA객체가 인터페이스를 의존 함으로써 의존성을 낮출수 있다.











