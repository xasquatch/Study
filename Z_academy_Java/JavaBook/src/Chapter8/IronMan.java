package Chapter8;

interface MyInterface {

	public static final int MEMBER1 = 10;
	int MEMBER2 = 10;

	public abstract void method1(int param);

	void method2(int param);
}

interface Figthable {
	int fire();
}

interface Transformable {
	void changeShape(boolean isHeroMode);
}

interface Heroable extends Figthable, Transformable {

	void upgrade();
}

public class IronMan implements Heroable{

	int weaponDamage = 100;
	
	@Override
	public int fire() {
		System.out.println("�߻�");
		return this.weaponDamage;
	}

	@Override
	public void changeShape(boolean isHeroMode) {
		if(isHeroMode) {
			System.out.println("����");			
		}else {
			System.out.println("Ż��");
		}
	}

	@Override
	public void upgrade() {
		int before = weaponDamage;
		weaponDamage += weaponDamage*0.1;
		System.out.println("���� ���� ���� : "+ before+" "+weaponDamage);
		
		
	}
	public static void main(String[] args) {
		
		IronMan man = new IronMan();
		man.fire();
		man.changeShape(true);
		man.upgrade();
		
	}
	
	
}