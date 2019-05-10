package com.willtoto.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.BoardDAO;
import com.willtoto.dto.BoardDTO;

public class CommandList implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		int count = dao.count();
		
		//하나의 화면마다 보여줄 글개수
		int pageSize = 5; 
		//현재 보여질(선택한) 페이지번호가 없으면 1페이지로 처리
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null){
		   pageNum = "1";
		}
		//현재 보여질(선택한) 페이지번호
		//현재 보여질(선택한) 페이지번호 "1" -> 기본정수 1로 변경
		int currentPage = Integer.parseInt(pageNum);
		//각 페이지마다 위쪽에 첫번째로 보여질 시작 글번호 구하기
		//(현재 보여질 페이지 번호-1)*한페이지당 보여질 글개수 15
		int startRow = (currentPage - 1)*pageSize;
		
		int pageCount = count / pageSize + (count%pageSize);
   		int pageBlock = 5;
		
   		int startPage = ((currentPage/pageBlock) - (currentPage%pageBlock == 0? 1 : 0) * pageBlock +1);
   		
   		int endPage = startPage + pageBlock -1;
   		if(endPage > pageCount){
   			//홈페이지 번호를 전체페이지수로 저장
   			endPage = pageCount;
   		}
   	
		
   		ArrayList<BoardDTO> dtos = dao.b_list(startRow, pageSize);
   		
		request.setAttribute("list", dtos);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		
	}

}
