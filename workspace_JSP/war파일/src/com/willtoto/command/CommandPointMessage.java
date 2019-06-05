package com.willtoto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.willtoto.dao.Point_trade_messageDAO;

public class CommandPointMessage implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String message_id = request.getParameter("message_id");
		String message = request.getParameter("message");
		
		Point_trade_messageDAO dao = new Point_trade_messageDAO();
		boolean result = dao.messageWrite(message_id, message);
		request.setAttribute("message", result);
	}

}
