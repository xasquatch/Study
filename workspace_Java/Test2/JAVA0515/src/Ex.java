import java.util.Date;

public class Ex {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("호빵");
		p.setHeight(30.8);
		
		System.out.println("이름 : "+p.getName());
		System.out.println("키 : "+p.getHeight());
		
	
	}
}

class Person {

	private String name;
	private Date birth;
	private String id;
	private double height;
	private double weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
