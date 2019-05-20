<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="mybean.MemberDto"%>
<%@page import="mybean.MemberDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/common.css" />
<link type="text/css" rel="stylesheet" href="../css/join.css" />
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bookmark.js"></script>
<script type="text/javascript" src="../js/joinCheck.js"></script>
<script type="text/javascript" src="../js/address.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>▒ 회원정보 수정 ▒</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("id");
	if (id == null)
		response.sendRedirect("login.jsp");

	MemberDao dao = MemberDao.getInstance();
	MemberDto member = dao.getUserInfo(id);
%>

<%@ include file="../bootstrap/header.jsp"%>
<div style="height: 50px;"></div>
<%@ include file="../bootstrap/menulink.jsp"%>
<div style="height: 50px;"></div>
<hr />
<hr />

<div style="clear: both;"></div>
<div id="contentWrapper">
	<div id="contentWrap">
		<div id="content">
			<div id="join_test">
				<div class="page-body">
					<form name="f" method="post" id="join_form"
						action="modify_pro.jsp">
						<div class="box-wrap">
							<ul class="join-form">
								<li><label>이름&nbsp;&nbsp;</label> 
									<input type="text" name="hname" id="hname" value="<%=member.getHname()%>"
										   class="MS_input_txt w137 input-label" size="15" maxlength="30" /></li>
								<li><label>아이디&nbsp;&nbsp;</label> 
									<input type="text" name="id" id="id" value="<%=member.getId()%>"
										   class="MS_input_txt w137 input-label" size="10" maxlength="12" readonly="readonly"/></li>
								<li><label>비밀번호&nbsp;&nbsp;</label> 
									<input type="password" name="password1" id="password1" class="MS_input_txt w137 input-label" 
										   value="" size="15" maxlength="20" /></li>
								<li><label>비밀번호 확인&nbsp;&nbsp;</label> 
									<input type="password" name="password2" id="password2" class="MS_input_txt w137 input-label" 
										   value="" size="15" maxlength="20" /></li>
								<li><label>이메일&nbsp;&nbsp;</label> 
									<input type="hidden" name="oldemail" value="" /> 
									<input type="text" name="email" id="email" class="MS_input_txt MS_input_txt06 w137 input-label" 
										   size="20" maxlength="35" id="email" value="<%=member.getEmail()%>" /></li>
								<li class="birth">
									<dl class="type1">
										<dd>
											<select name="birthyear" class="new-birth"
												style="width: 60px; height: 40px;">
												<option value="">생년</option>
												<option value=2001 <%if (member.getBirthyear() == 2001) {%>
													selected <%}%>>2001</option>
												<option value=2000 <%if (member.getBirthyear() == 2000) {%>
													selected <%}%>>2000</option>
												<option value=1999 <%if (member.getBirthyear() == 1999) {%>
													selected <%}%>>1999</option>
												<option value=1998 <%if (member.getBirthyear() == 1998) {%>
													selected <%}%>>1998</option>
												<option value=1997 <%if (member.getBirthyear() == 1997) {%>
													selected <%}%>>1997</option>
												<option value=1996 <%if (member.getBirthyear() == 1996) {%>
													selected <%}%>>1996</option>
												<option value=1995 <%if (member.getBirthyear() == 1995) {%>
													selected <%}%>>1995</option>
												<option value=1994 <%if (member.getBirthyear() == 1994) {%>
													selected <%}%>>1994</option>
												<option value=1993 <%if (member.getBirthyear() == 1993) {%>
													selected <%}%>>1993</option>
												<option value=1992 <%if (member.getBirthyear() == 1992) {%>
													selected <%}%>>1992</option>
												<option value=1991 <%if (member.getBirthyear() == 1991) {%>
													selected <%}%>>1991</option>
												<option value=1990 <%if (member.getBirthyear() == 1990) {%>
													selected <%}%>>1990</option>
												<option value=1989 <%if (member.getBirthyear() == 1989) {%>
													selected <%}%>>1989</option>
												<option value=1988 <%if (member.getBirthyear() == 1988) {%>
													selected <%}%>>1988</option>
												<option value=1987 <%if (member.getBirthyear() == 1987) {%>
													selected <%}%>>1987</option>
												<option value=1986 <%if (member.getBirthyear() == 1986) {%>
													selected <%}%>>1986</option>
												<option value=1985 <%if (member.getBirthyear() == 1985) {%>
													selected <%}%>>1985</option>
												<option value=1984 <%if (member.getBirthyear() == 1984) {%>
													selected <%}%>>1984</option>
												<option value=1983 <%if (member.getBirthyear() == 1983) {%>
													selected <%}%>>1983</option>
												<option value=1982 <%if (member.getBirthyear() == 1982) {%>
													selected <%}%>>1982</option>
												<option value=1981 <%if (member.getBirthyear() == 1981) {%>
													selected <%}%>>1981</option>
												<option value=1980 <%if (member.getBirthyear() == 1980) {%>
													selected <%}%>>1980</option>
											</select>
										</dd>
										<dd>
											<select name="birthmonth" class="new-birth"
												style="width: 60px; height: 40px;">
												<option value="">월</option>
												<option value="01" <%if (member.getBirthmonth() == 1) {%>
													selected <%}%>>1</option>
												<option value="02" <%if (member.getBirthmonth() == 2) {%>
													selected <%}%>>2</option>
												<option value="03" <%if (member.getBirthmonth() == 3) {%>
													selected <%}%>>3</option>
												<option value="04" <%if (member.getBirthmonth() == 4) {%>
													selected <%}%>>4</option>
												<option value="05" <%if (member.getBirthmonth() == 5) {%>
													selected <%}%>>5</option>
												<option value="06" <%if (member.getBirthmonth() == 6) {%>
													selected <%}%>>6</option>
												<option value="07" <%if (member.getBirthmonth() == 7) {%>
													selected <%}%>>7</option>
												<option value="08" <%if (member.getBirthmonth() == 8) {%>
													selected <%}%>>8</option>
												<option value="09" <%if (member.getBirthmonth() == 9) {%>
													selected <%}%>>9</option>
												<option value="10" <%if (member.getBirthmonth() == 10) {%>
													selected <%}%>>10</option>
												<option value="11" <%if (member.getBirthmonth() == 11) {%>
													selected <%}%>>11</option>
												<option value="12" <%if (member.getBirthmonth() == 12) {%>
													selected <%}%>>12</option>
											</select>
										</dd>
										<dd>
											<select name="birthdate" class="new-birth"
												style="width: 60px; height: 40px;">
												<option value="">일</option>
												<option value="01" <%if (member.getBirthdate() == 1) {%>
													selected <%}%>>1</option>
												<option value="02" <%if (member.getBirthdate() == 2) {%>
													selected <%}%>>2</option>
												<option value="03" <%if (member.getBirthdate() == 3) {%>
													selected <%}%>>3</option>
												<option value="04" <%if (member.getBirthdate() == 4) {%>
													selected <%}%>>4</option>
												<option value="05" <%if (member.getBirthdate() == 5) {%>
													selected <%}%>>5</option>
												<option value="06" <%if (member.getBirthdate() == 6) {%>
													selected <%}%>>6</option>
												<option value="07" <%if (member.getBirthdate() == 7) {%>
													selected <%}%>>7</option>
												<option value="08" <%if (member.getBirthdate() == 8) {%>
													selected <%}%>>8</option>
												<option value="09" <%if (member.getBirthdate() == 9) {%>
													selected <%}%>>9</option>
												<option value="10" <%if (member.getBirthdate() == 10) {%>
													selected <%}%>>10</option>
												<option value="11" <%if (member.getBirthdate() == 11) {%>
													selected <%}%>>11</option>
												<option value="12" <%if (member.getBirthdate() == 12) {%>
													selected <%}%>>12</option>
												<option value="13" <%if (member.getBirthdate() == 13) {%>
													selected <%}%>>13</option>
												<option value="14" <%if (member.getBirthdate() == 14) {%>
													selected <%}%>>14</option>
												<option value="15" <%if (member.getBirthdate() == 15) {%>
													selected <%}%>>15</option>
												<option value="16" <%if (member.getBirthdate() == 16) {%>
													selected <%}%>>16</option>
												<option value="17" <%if (member.getBirthdate() == 17) {%>
													selected <%}%>>17</option>
												<option value="18" <%if (member.getBirthdate() == 18) {%>
													selected <%}%>>18</option>
												<option value="19" <%if (member.getBirthdate() == 19) {%>
													selected <%}%>>19</option>
												<option value="20" <%if (member.getBirthdate() == 20) {%>
													selected <%}%>>20</option>
												<option value="21" <%if (member.getBirthdate() == 21) {%>
													selected <%}%>>21</option>
												<option value="22" <%if (member.getBirthdate() == 22) {%>
													selected <%}%>>22</option>
												<option value="23" <%if (member.getBirthdate() == 23) {%>
													selected <%}%>>23</option>
												<option value="24" <%if (member.getBirthdate() == 24) {%>
													selected <%}%>>24</option>
												<option value="25" <%if (member.getBirthdate() == 25) {%>
													selected <%}%>>25</option>
												<option value="26" <%if (member.getBirthdate() == 26) {%>
													selected <%}%>>26</option>
												<option value="27" <%if (member.getBirthdate() == 27) {%>
													selected <%}%>>27</option>
												<option value="28" <%if (member.getBirthdate() == 28) {%>
													selected <%}%>>28</option>
												<option value="29" <%if (member.getBirthdate() == 29) {%>
													selected <%}%>>29</option>
												<option value="30" <%if (member.getBirthdate() == 30) {%>
													selected <%}%>>30</option>
												<option value="31" <%if (member.getBirthdate() == 31) {%>
													selected <%}%>>31</option>
											</select>
										</dd>
									</dl>
								</li>
								<li class="gender">&nbsp;
									<label><input type="radio" name="sex" value="1" class="input-radio" /> 남</label> 
									<label><input type="radio" name="sex" value="2" class="input-radio" checked />여</label>
								</li>
								<li><label>휴대폰번호&nbsp;&nbsp;</label>
									<input type="text" name="etcphone" id="etcphone" class="MS_input_tel w137 input-label" 
										   size="15" maxlength="30" value="<%=member.getEtcphone() %>" /></li>
								<li><input type="text" name="postcode" id="sample6_postcode" value="<%=member.getPostcode()%>">
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br></li>
								<li><input type="text" name="address" id="sample6_address" value="<%=member.getAddress()%>"> 
									<input type="text" name="address2" id="sample6_address2" value="<%=member.getAddress2()%>"></li>
							</ul>
						</div>
						<div class="new-btn-area">
							<a href="javascript:send();"> 
								<span class="buttonlogin btnlogin" style="line-height: 35px;">수정 완료</span>
							</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../bootstrap/footer.jsp"%>
</body>
</html>