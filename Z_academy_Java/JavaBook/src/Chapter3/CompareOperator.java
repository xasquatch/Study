package Chapter3;

public class CompareOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String s1 = new String("Hello");	// �Ҵ��� : ������ �ּҰ� �Ҵ�
	String s2 = new String("Hello");	//		�Ҵ�� �ּҹ������� ���� �Ҵ�
	
	String s3 = "Hello";	// �Ҵ��� : ���ͷ����̺� �������,	�ߺ��� ���̸� �� �ּҰ��� ���� �Ҵ�
	String s4 = "Hello";	//		���ͷ� ���̺� : �ߺ��� ���� ������� ����
	
	System.out.println((s3==s4)+":"+(s3 == s4));

	

System.out.println("--------------------------------------------------------");

System.out.println('A'>'B');	//65>66
	//�񱳿��꿡���� ����ȯ
	//int ������ ���� - �ϴ� int�� ���� : 65==100
System.out.println('A'==65);
	//�� �ǿ����� �� ū Ÿ������ ����ȯ :3.0 == 3.0
System.out.println(3 == 3.0);

	//���� ���� : 0.1�� ǥ�� ����
System.out.println(0.1+":"+0.1f+":"+(0.1==0.1f));
System.out.println(0.5+":"+0.5f+":"+(0.5==0.5f));
	double d1 = 0.1;
	float f1 = 0.1f;
System.out.println((int)(d1*10)==(int)(f1*10));
System.out.println((float)d1==f1);

	//���ڿ������� ==�� equals

System.out.println((s1 == s2)+":"+s1.equals(s2));
		
		
		
		
		
	}

}
