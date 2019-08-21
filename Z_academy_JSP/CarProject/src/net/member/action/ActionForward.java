package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionForward implements Action {
	// 페이지 이동 방식 여부값을 저장할 변수 RequestDispather, Sendredirect,

	private boolean isRedirect = false; // true또는 false가 저장

	/* 이동할 뷰페이지 경로 주소값을 저장할 변수 */
	private String path = null;

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

	
}
