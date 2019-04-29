package ch08.inter;

interface Fightable{
	public abstract int fire();
}

interface Transformable{
	void changeShape(boolean isHeroMode);
}
interface Heroable extends Fightable, Transformable {

	int WeaponDamage = 9;
	
	void upgrade();
}
public class IronMan implements Heroable {

	int WeaponDamage = 100;

	@Override
	public void changeShape(boolean isHeroMode) {
		if (isHeroMode) {
			System.out.println("�尩 ����");
		}else {
			System.out.println("�尩 ����");
		}
		
	}

	@Override
	public int fire() {
		System.out.println("���߻�???��������������");
		return this.WeaponDamage;
	}

	@Override
	public void upgrade() {
		
		int before = WeaponDamage;
		WeaponDamage += WeaponDamage *0.1;
		System.out.println("���� ���ɰ���???"+before+"��"+WeaponDamage);
		
	}
	
	public static void main(String[] args) {
		
		IronMan man = new IronMan();	System.out.println(man.WeaponDamage);	man.changeShape(true);	man.upgrade(); man.fire();
		System.out.println("---------------------------------");
		Object obj = man;	
		System.out.println("---------------------------------");
		Heroable hero = man;	hero.changeShape(true);	hero.fire();	hero.upgrade(); System.out.println(hero.WeaponDamage);
		System.out.println("---------------------------------");
		Fightable fight = man;	fight.fire();
		System.out.println("---------------------------------");
		Transformable trans = man;	trans.changeShape(true);
		
		
		
		
		
		
	}
}
