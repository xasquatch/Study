package mybean;

//여러 데이터를 하나의 클래스 단위로 묶어서 insert처리할 DTO클래스
//DB에 존재하는 레코드를 검색하여 가져와서 저장할 용도의  DTO클래스
public class SawonDTO {

	private int no;
	private String id;
	private String name;
	private String pass;
	private int age;
	private String addr;
	private String extension;
	private String dept;

	public SawonDTO() {
	}

	public SawonDTO(int no, String id, String name, String pass, int age, String addr, String extension, String dept) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.age = age;
		this.addr = addr;
		this.extension = extension;
		this.dept = dept;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
