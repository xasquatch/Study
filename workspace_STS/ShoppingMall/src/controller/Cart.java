package controller;

import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

//��ǰ�� ������  ArrayList�� �����ϰ�
//�Ǵ� īƮ�� ���� ��ǰ�� �����Ѵٸ� ������ ������Ű�� Ŭ����
//īƮ�� ����� ��ǰ�� �����ϴ� ��ɰ� ��� ��ǰ�� ��Ʈ���� ���� ��Ű�� Ŭ����
public class Cart {

//	�������� sucartbean��ǰ(���۾� ������ǰ�Ǵ� ����������ǰ)�� �����ϱ� ����
//	�뵵�� ArrayList��ü ����
//	���� �� ArrayList��ü�� �����ϰ� �ִ� Cart��ü�� ���߿�  session������ ����ȴ�
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();

	public List<SuCartBean> getItemlist() {
		return itemlist;
	}

//	�޼ҵ弳��
//	sujakinfo.jsp���������� ī���� ��ư�� ������ ��
//	shoppingcontroller.java�� sutoolcart(sucartbean cartbean, httpsession session)�޼ҵ���
//	���ڷ� ������ ���� cartbean��ü�� �ٽ� �Ʒ��� push(sucartbeam cartbean)�޼ҵ���
//	���ڷ� ���޹޾�  arraylist��ü�� ��ǰ�� �߰���Ű�� �޼ҵ���
//	
//	��� 1: ���� arraylist������ sucartbean��ǰ��ü ������ �����Ѵٸ�
//			������ ������Ű��, ������ ��ǰ��ü ������ �����ϴ��� �˾Ƴ����ִ� �÷��װ���  Ȱ��
//			
	public void push(SuCartBean cartbean) {

		boolean alreadysutool = false;

//		arraylist itemlist�� ����Ǿ� �ִ� sucartbean��ü�� ������ŭ �ݺ�
		for (SuCartBean suCartBean : itemlist) {

//			ArrayList�� ����Ǿ� �ִ� sucartbean��ü�� ���۾� ������ȣ��
//			push�޼ҵ��� �Ű������� ���޹��� sucartbean��ü�� ���۾�������ȣ�� ���Ͽ� ������
			if (cartbean.getSuno() == suCartBean.getSuno()) {

				suCartBean.setSuqty(suCartBean.getSuqty() + cartbean.getSuqty());

				alreadysutool = true;
				break;
			}

		}

		if (alreadysutool == false) {
			itemlist.add(cartbean);
		}

	}

}
