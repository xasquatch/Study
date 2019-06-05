package com.willtoto.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.BoardDAO;
import com.willtoto.dao.MemberDAO;
import com.willtoto.dao.Point_trade_okDAO;
import com.willtoto.dto.BoardDTO;
import com.willtoto.dto.MemberDTO;
import com.willtoto.dto.Point_trade_okDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CommandPointTradeOkSelect implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Point_trade_okDAO dao = new Point_trade_okDAO();
		ArrayList<Point_trade_okDTO> dtos = dao.trade_ok_Select();
		request.setAttribute("trade_list", dtos);
		
		Document doc = null;
		try {
			doc = Jsoup.connect("http://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid1=105&sid2=230").get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements titles = doc.select(".type06_headline li dl dt:nth-child(2)");
 	
		String[] title = new String[10];
		String[] link = new String[10];
		
		int i = 0;
		int j = 0;
		for(Element e: titles){
			title[i] = e.text();
			i++;
		}	
 
 
		
		Elements links = doc.select(".type06_headline li dl dt:nth-child(2) a[href]");
		for(Element l: links){
			link[j] = l.attr("abs:href");
			j++;
		}	
		
		request.setAttribute("title", title);
		request.setAttribute("link", link);
		
		MemberDAO rankdao = new MemberDAO();
		ArrayList<MemberDTO> Top5 = rankdao.point_Top5rank();
		ArrayList<MemberDTO> Bottom5 = rankdao.point_Bottom5rank();
		request.setAttribute("Top5", Top5);
		request.setAttribute("Bottom5", Bottom5);
		
		BoardDAO Write5 = new BoardDAO();
		ArrayList<BoardDTO> Write5_list = Write5.i_list();
		request.setAttribute("Write5_list", Write5_list);
		
	}

}
