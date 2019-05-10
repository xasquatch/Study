package com.willtoto.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.MemberDAO;
import com.willtoto.dto.MemberDTO;

public class CommandPointRank implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> Top5dtos = dao.point_Top5rank();
		ArrayList<MemberDTO> Bottom5dtos = dao.point_Bottom5rank();
		request.setAttribute("Top5", Top5dtos);
		request.setAttribute("Bottom5", Bottom5dtos);
		
	}

}
