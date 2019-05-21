<%@page import="mymember.MemberDao"%>
<%@page import="mymember.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내정보</title>
<link rel="stylesheet" href="../css/main.css"/>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
//우편번호 api
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('address').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('address2').focus();
        }
    }).open();
}
</script>
</head>
<body>
	<%@include file="../inc/top_lg.jsp" %>
	
	<%
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.getMember(id);
	
	String mem_name = dto.getMem_name();
	String gender = dto.getGender();
	String[] birth = dto.getBirth().split("-");
	String year = birth[0];
	String month = birth[1];
	String day = birth[2];
	int postcode = dto.getPostcode();
	String address = dto.getAddress();
	String address2 = dto.getAddress2();
	String email = dto.getEmail();
	%>
	
		<header>
			<div id="ui_top_banner">
				<div id="wrap">
					<a href="../index.jsp"><img src="../images/new_logo.png" alt="Hbay Logo" id="logo"/></a>
					<h1 id="ui_title">내정보</h1>
					
					<ul id="ui_top_menu">
						<li><a href="change_info.jsp" class="ui_selected">내정보 관리</a></li>
						<li><a href="pass_change.jsp">비밀번호 변경</a></li>
						<li><span class="divider"></span></li>
						<li><a href="close_acc.jsp">회원탈퇴</a></li>
						<div class="clear"></div>
					</ul>
					<div class="clear"></div>
				</div>
			</div>
		</header>
		
		<div id="wrap" class="wrap_min">
			<article>
				<div id="change_info">
					<h1>내정보 관리</h1>
					<p>내정보를 최신 정보로 관리해 주세요.</p>
					<p>아이디/비밀번호 분실 및 보호조치 해제를 위해 최신 정보로 내정보를 관리하세요.</p>
				</div>
				<form action="change_infoProc.jsp" method="post">
					<div id="user_info_form">
					<table>
						<tr>
							<td class="label_td"><label for="id">아이디</label></td>
							<td><%=id %></td>
						</tr>
						<tr>
							<td class="label_td"><label for="name">이름</label></td>
							<td><input type="text" name="mem_name" id="mem_name" value="<%=mem_name %>" placeholder="이름" required/></td>
						</tr>
						<tr>
							<td class="label_td"><label for="male">성별</label></td>
							<td>
								<input type="radio" name="gender" id="male" value="M" <%if(gender.equals("M")){%>checked<%}%>/>
								<label for="male" class="genderBtn">남자</label>&nbsp;
								<input type="radio" name="gender" id="female" value="F" <%if(gender.equals("F")){%>checked<%}%>/>
								<label for="female" class="genderBtn">여자</label>
							</td>
						</tr>
						<tr>
							<td class="label_td"><label for="birth">생일</label></td>
							<td>
								<div id="birth">
									<input type="text" name="year" id="year" value="<%=year %>" placeholder="년" required/>
									<span class="divider"></span>
									<select name="month" id="month">
										<option value="mon">월</option>
										<option value="1" <%if(month.equals("01")){%>selected<%}%>>1</option>
										<option value="2" <%if(month.equals("02")){%>selected<%}%>>2</option>
										<option value="3" <%if(month.equals("03")){%>selected<%}%>>3</option>
										<option value="4" <%if(month.equals("04")){%>selected<%}%>>4</option>
										<option value="5" <%if(month.equals("05")){%>selected<%}%>>5</option>
										<option value="6" <%if(month.equals("06")){%>selected<%}%>>6</option>
										<option value="7" <%if(month.equals("07")){%>selected<%}%>>7</option>
										<option value="8" <%if(month.equals("08")){%>selected<%}%>>8</option>
										<option value="9" <%if(month.equals("09")){%>selected<%}%>>9</option>
										<option value="10" <%if(month.equals("10")){%>selected<%}%>>10</option>
										<option value="11" <%if(month.equals("11")){%>selected<%}%>>11</option>
										<option value="12" <%if(month.equals("12")){%>selected<%}%>>12</option>
									</select>
									<span class="divider"></span>
									<input type="text" name="day" id="day" value="<%=day %>" placeholder="일" required/>
								</div>
							</td>
						</tr>
						<tr>
							<td class="label_td"><label for="address">주소</label></td>
							<td>
								<input type="text" name="postcode" id="postcode" value="<%=postcode %>" placeholder="우편번호" class="textWithBtn" required>
								<input type="button" onclick="execDaumPostcode()" value="찾기" class="btn"><br/>
								<input type="text" name="address" id="address" value="<%=address %>" placeholder="주소" required readonly><br/>
								<input type="text" name="address2" id="address2" value="<%=address2 %>" placeholder="상세주소" required><br/>
							</td>
						</tr>
						<tr>
							<td class="label_td"><label for="email">이메일</label></td>
							<td>
								<input type="text" name="email" id="email" value="<%=email %>" placeholder="이메일" required/>
							</td>
						</tr>
					</table>
					</div>
					<div id="pass_recheck_btn">
						<input type="submit" value="확인" class="btn"/>
						<input type="reset" value="취소" class="btn"/>
					</div>
				</form>
			</article>
		</div>
		
		<%@include file="../inc/footer.jsp" %>
</body>
</html>