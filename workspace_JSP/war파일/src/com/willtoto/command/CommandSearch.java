package com.willtoto.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.BoardDAO;
import com.willtoto.dto.BoardDTO;

public class CommandSearch implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String select = request.getParameter("select");
		String keyword = request.getParameter("keyword");
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> dto = dao.search(select, keyword);
		request.setAttribute("search_list", dto);
		request.setAttribute("count", dto.size());
	}

}
