<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" href="../../favicon.ico">
  <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
     <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<center>
<!-- 본문내용 -->
    <div class="container">
    
    <%--MemberFrontController서블릿에.. 로그인 처리 요청시! 입력한 id와 패스워드 전달 --%>
      <form class="form-signin" action="./MemberLoginAction.me" id="join">    
        <h2 class="form-signin-heading">Please sign in</h2>
        	<label class="sr-only">User ID</label>
        		<input type="text" id="id" name="id"  placeholder="아이디" required autofocus>
        	<label for="inputPassword" class="sr-only">Password</label>
        		<input type="password" id="pass" name="pass" class="form-control" placeholder="패스워드" required>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div> <!-- /container -->
</center>
<!-- 본문내용 -->
	
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/CarProject/js/ie10-viewport-bug-workaround.js"></script>	
</body>
</html>