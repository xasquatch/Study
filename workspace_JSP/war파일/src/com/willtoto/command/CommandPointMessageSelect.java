package com.willtoto.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.Point_trade_messageDAO;
import com.willtoto.dto.Point_trade_messageDTO;

public class CommandPointMessageSelect implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Point_trade_messageDAO dao = new Point_trade_messageDAO();
		ArrayList<Point_trade_messageDTO> dtos = dao.messageSelect();
		request.setAttribute("message_list", dtos);
	}

}
