package Test2;

class Circle{
	
	int x, y, radius;
	
	Circle(){}
	Circle(int a, int b, int radius){
		this.x = a;
		this.y = b;
		this.radius = radius;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	void setX(int a){
		this.x = a;
	}
	void setY(int b){
		this.y = b;
	}
	void setRadius(int radius){
		this.radius = radius;
	}

	@Override
	public boolean equals(Object arg0) {
	
		boolean result = false;
		Circle c = (Circle)arg0;
		if(this.x == c.x &&this.y == c.y&&this.radius == c.radius) {
			result = true;
		}
		return result;
	}
	@Override
	public String toString() {
		double area = radius*radius*3.14;
		return "면적이"+area+"인 원입니다";
	}
	
}

public class Test {

	public static void main(String[] args) {
		
		Circle c1 = new Circle(20,30,10);
		Circle c2 = new Circle();
		c2.setX(20);
		c2.setY(30);
		c2.setRadius(10);
		if(c1.equals(c2)) System.out.println("같은 원이다");
		else System.out.println("다른 원이다.");
		
		System.out.println(c1);
		System.out.println(c2);
	}

}
