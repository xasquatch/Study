<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--file.1 JQUERY-->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!--file.2 IE8이상 버전 호환성 확장용 (2 lib)-->
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script><script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<!--file.3 부트스트랩 (2 lib)-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"><script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<!-- END -->
<link href="css/style.css" rel="stylesheet">
<script src="js/script.js"></script>
<title></title>
</head>
<body>
	<form>
  <input type="radio" name="tab" id="menu"/>
  <div class="container">
    <input type="radio" name="tab" checked="checked" id="home"/>
    <section class="home">
      <h1>Home</h1>
      <label for="home"></label>
    </section>
    <input type="radio" name="tab" id="about"/>
    <section class="about">
      <h1>About</h1>
      <label for="about"></label>
    </section>
    <input type="radio" name="tab" id="work"/>
    <section class="work">
      <h1>Work</h1>
      <label for="work"></label>
    </section>
    <input type="radio" name="tab" id="contact"/>
    <section class="contact">
      <h1>Contact</h1>
      <label for="contact"></label>
    </section>
  </div>
  <div class="menu">
    <div>
      <label for="menu"></label>
      <label for="home"></label>
    </div>
  </div>
</form>
	
	
</body>
</html>