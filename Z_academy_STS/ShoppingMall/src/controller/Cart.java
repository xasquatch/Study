package controller;

import java.util.ArrayList;
import java.util.List;

import model.SuCartBean;

//»óÇ°¿¡ ³»¿ëÀ»  ArrayList¿¡ ÀúÀåÇÏ°í
//¶Ç´Â Ä«Æ®¿¡ ±âÁ¸ »óÇ°ÀÌ Á¶ÀçÇÑ´Ù¸é ¼ö·®¸¸ Áõ°¡½ÃÅ°´Â Å¬·¡½º
//Ä«Æ®¿¡ ÀúÀåµÈ »óÇ°À» »èÁ¦ÇÏ´Â ±â´É°ú ¸ğµç »óÇ°À» ¯—Æ®¿¡¼­ »èÁ¦ ½ÃÅ°´Â Å¬·¡½º
public class Cart {

//	¿©·¯°³ÀÇ sucartbean»óÇ°(¼öÀÛ¾÷ °ø±¸»óÇ°¶Ç´Â Àüµ¿°ø±¸»óÇ°)À» ÀúÀåÇÏ±â À§ÇÑ
//	¿ëµµÀÇ ArrayList°´Ã¼ »ı¼º
//	Âü°í ÀÌ ArrayList°´Ã¼¸¦ Æ÷ÇÔÇÏ°í ÀÖ´Â Cart°´Ã¼´Â ³ªÁß¿¡  session¿µ¿ª¿¡ ÀúÀåµÈ´Ù
	private List<SuCartBean> itemlist = new ArrayList<SuCartBean>();

	public List<SuCartBean> getItemlist() {
		return itemlist;
	}

//	¸Ş¼Òµå¼³¸í
//	sujakinfo.jspÆäÀÌÁö¿¡¼­ Ä«µå´ã±â ¹øÆ°À» ´­·¶À» ‹š
//	shoppingcontroller.javaÀÇ sutoolcart(sucartbean cartbean, httpsession session)¸Ş¼ÒµåÀÇ
//	ÀÎÀÚ·Î Àü´ŞÀ» ¹ŞÀº cartbean°´Ã¼¸¦ ´Ù½Ã ¾Æ·¡ÀÇ push(sucartbeam cartbean)¸Ş¼ÒµåÀÇ
//	ÀÎÀÚ·Î Àü´Ş¹Ş¾Æ  arraylist°´Ã¼¿¡ »óÇ°À» Ãß°¡½ÃÅ°´Â ¸Ş¼ÒµåÀÓ
//	
//	±â´É 1: ±âÁ¸ arraylist°ø°£¿¡ sucartbean»óÇ°°´Ã¼ Á¤º¸°¡ Á¸ÀçÇÑ´Ù¸é
//			¼ö·®¸¸ Áõ°¡½ÃÅ°°í, ±âÁ¸¿¡ »óÇ°°´Ã¼ Á¤º¸°¡ Á¸ÀçÇÏ´ÂÁö ¾Ë¾Æ³¾¼öÀÖ´Â ÇÃ·¡±×°ªÀ»  È°¿ë
//			
	public void push(SuCartBean cartbean) {

		boolean alreadysutool = false;

//		arraylist itemlist¿¡ ÀúÀåµÇ¾î ÀÖ´Â sucartbean°´Ã¼ÀÇ °³¼ö¸¸Å­ ¹İº¹
		for (SuCartBean suCartBean : itemlist) {

//			ArrayList¿¡ ÀúÀåµÇ¾î ÀÖ´Â sucartbean°´Ã¼ÀÇ ¼öÀÛ¾÷ °ø±¸¹øÈ£¿Í
//			push¸Ş¼ÒµåÀÇ ¸Å°³º¯¼ö·Î Àü´Ş¹ŞÀº sucartbean°´Ã¼ÀÇ ¼öÀÛ¾÷°ø±¸¹øÈ£¿Í ºñ±³ÇÏ¿© °°À¸¸é
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

	public void deleteCart(int suno) {

		for (SuCartBean suCartBean : itemlist) {

			if (suCartBean.getSuno() == suno) {
				itemlist.remove(suCartBean);
				break;
			}

		}

	}

}
