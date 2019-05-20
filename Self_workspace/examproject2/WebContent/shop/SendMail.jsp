<%@page import="mail.SMTPAuthenticator"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Address"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 한글 인코딩
	request.setCharacterEncoding("utf-8");
	
	// 입력값 받음
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	// 정보를 담을 객체
	Properties p = new Properties();
	
	p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP
	
	// SMTP 서버에 접속하기 위한 정보들
	p.put("mail.smtp.port", "465");
	p.put("mail.smtp.starttls.enable", "true");
	p.put("mail.smtp.auth", "true");
	p.put("mail.smtp.debug", "true");
	p.put("mail.smtp.socketFactory.port", "465");
	p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	p.put("mail.smtp.socketFactory.fallback", "false");

	try{
	
	    Authenticator auth = new SMTPAuthenticator();
	    Session ses = Session.getInstance(p, auth);
	
	    ses.setDebug(true);
	
	    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
	    msg.setSubject(subject); // 제목
	
	    Address fromAddr = new InternetAddress(from);
	    msg.setFrom(fromAddr); // 보내는 사람
	
	    Address toAddr = new InternetAddress(to);
	    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
	
	    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 한글 인코딩
	
	    Transport.send(msg); // 전송
	} catch(Exception e){
	    e.printStackTrace();
	    out.println("<script>alert('메일을 전송하지 못했습니다');history.back();</script>");
	    // 오류 발생시 뒤로 돌아가도록
	    return;
	}
	
	// 성공 시
	out.println("<script>alert('메일 전송이 완료되었습니다');location.href='contact.jsp';</script>");
%>
