<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/CarProject/css/default.css" rel="stylesheet" type="text/css">
<link href="/CarProject/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>

<!-- 본문내용 -->
<center>

		<article>
			<h1>Join Us</h1>
			<%--MemberFrontController서블릿에.. 회원가입 처리 요청! --%>
			<form action="./MemberJoinAction.me" id="join" method="post">
				
				<fieldset>
				<legend>Basic Info</legend>
				<label>User ID</label>
					<input type="text" name="id" class="id"><br>
				<label>Password</label>
					<input type="password" name="pass"><br>
				<label>Retype Password</label>
					<input type="password" name="pass2"><br>
				<label>Name</label>
					<input type="text" name="name"><br>
				<label>E-Mail</label>
					<input type="email" name="email"><br>
				<label>Retype E-Mail</label>
					<input type="email" name="email2"><br>
				</fieldset>
				
				<fieldset>
				<legend>Optional</legend>
				<label>Address</label>
					<input type="text" name="address"><br>
				<label>Phone Number</label>
					<input type="text" name="phone"><br>
				<label>Mobile Phone Number</label>
					<input type="text" name="mobile"><br>
				</fieldset>
				<fieldset>
						<input type="submit" value="Submit" class="submit">
						<input type="reset" value="Cancel" class="cancel">
				</fieldset>			
			</form>
		</article>

</center>
<!-- 본문내용 -->
</body>
</html>