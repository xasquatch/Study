package controller;

import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

//��ǰ�� ������ ArrayList�� �����ϰ�
//�Ǵ� īƮ�� ���� ��ǰ�� ���� �Ѵٸ� ������ ���� ��Ű�� Ŭ����,
//īƮ�� ����� ��ǰ�� �����ϴ� ��ɰ� ��� ��ǰ�� īƮ���� ���� ��Ű�� Ŭ����
public class Cart {//���� : ���۾����� �Ӹ� �ƴ϶� ���������� ���ÿ� ����Ҽ� �ֱ⋚����
				   //     �Ϻη� �ϳ��� CartŬ������ ����

	//�������� SuCartBean��ǰ(���۾�������ǰ �Ǵ� ����������ǰ)�� �����ϱ� ����
	//�뵵��? ArrayList��ü����
	//����! �� ArrayList��ü�� �����ϰ� �ִ� Cart��ü�� ���߿� session������ ����ȴ�.
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();
	
	//ArrayList��ü�� ��ȯ�ϴ� �޼ҵ�
	public List<SuCartBean>  getItemlist(){
		return itemlist;
	}
	
	//�޼ҵ� ����!!
	//SuJakInfo.jsp���������� "ī����"��ư�� ��������..
	//ShoppingController.java��  
	//sutoolCart(SuCartBean cartbean, HttpSession sesion)�޼ҵ���...
	//���ڷ� ���޹��� cartbean��ü�� �ٽ�!! �Ʒ��� push(SuCartBean cartbean)�޼ҵ���
	//���ڷ� ���� �޾�... ArrayList��ü�� ��ǰ�� �߰���Ű�� �޼ҵ���.
	//�ϴ���:
	//   ������ ArrayList������ SuCartBean��ǰ��ü ������ �����Ѵٸ�..
	//   ������ ���� ��Ű��, ������ ��ǰ��ü ������ �����ϴ��� �������� �ʴ��� �˾Ƴ���
	//   �÷��װ��� Ȱ����.
	public void push(SuCartBean cartbean) {
		//������ ��ǰ�� �ִ����� �˾Ƴ��� ���� ����
		boolean alreadysutool = false;
		
		//ArrayList itemlist�� ����Ǿ� �ִ� SuCartBean��ü�� ���� ��ŭ �ݺ�
		for(SuCartBean suCartBean  : itemlist) {
			
			//ArrayList�� ����Ǿ� �ִ� SuCartBean��ü�� ���۾�������ȣ��
			//push�޼ҵ��� �Ű������� ���޹޴� SuCartBean��ü��  ���۾�������ȣ��
			//���Ͽ� ������...
			if(cartbean.getSuno() == suCartBean.getSuno()) {
				//������ ��ǰ�� ���� �ϱ⿡ ������ ����
				suCartBean.setSuqty(suCartBean.getSuqty() 
									+ cartbean.getSuqty());
				//������ ��ǰ�� ���� �ϸ�  true����
				alreadysutool = true;
				break;
			}//if
		}//for
		//������ ��ǰ�� ���� ��쿡�� ��ǰ�� �߰� ���� �־�� �մϴ�.
		if(alreadysutool == false) {
			//ArrayList��ü�� ���ο� SuCartBean��ǰ��ü �߰�
			itemlist.add(cartbean);
		}
		
	}//push�޼ҵ� ��
	
}//CartŬ���� ��




