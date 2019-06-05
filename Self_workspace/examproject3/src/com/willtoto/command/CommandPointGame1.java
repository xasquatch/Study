package com.willtoto.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.Point_game1DAO;
import com.willtoto.dto.Point_game1DTO;

public class CommandPointGame1 implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Point_game1DAO dao = new Point_game1DAO();
		ArrayList<Point_game1DTO> dtos = dao.getGame1();
		request.setAttribute("win", dtos);
	}

}
