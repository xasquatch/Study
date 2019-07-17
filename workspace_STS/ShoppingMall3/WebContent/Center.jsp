<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<meta content='width=device-width, initial-scale=1 ,maximum-scale=1 ,user-scalable=no' name="viewport">

<!-- Bootstrap 3.3.2 CSS-->
<link href='bootstrap/css/bootstrap.min.css' rel="stylesheet" type="text/css">

<!--Jquery 2.1.3  -->
<script src="jQuery/jQuery-2.1.3.min.js"></script>
<!-- Bootstrap 3.3.2 js -->
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</head>
<body  bgcolor="black">
	<div id="carousel-example-generic" class="carousel slide" 
	data-ride="carousel"  width="1000">
	
	<ol class="carousel-indicators">
		<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		<li data-target="#carousel-example-generic" data-slide-to="2" ></li>
		<li data-target="#carousel-example-generic" data-slide-to="3"></li>		
	</ol>
	<!-- slides -->
	<div class="carousel-inner" role="listbox" width="1000">
		<div class="item active">
			<img alt="" src="img/cmain1.JPG" width="1000">
			<div class="carousel-caption"></div>
		</div>
		<div class="item">
			<img alt="" src="img/cmain2.JPG" width="1000">
			<div class="carousel-caption"></div>
		</div>
		<div class="item">
			<img alt="" src="img/cmain3.JPG" width="1000">
			<div class="carousel-caption"></div>
		</div>
		<div class="item">
			<img alt="" src="img/cmain4.JPG" width="1000">
			<div class="carousel-caption"></div>
		</div>
		<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
		</div>	
	</div>
	<p>
	<table width="1000">
		<tr height="200">
			<td align="center" width="250">
				<img alt="" src="img/center1.JPG" width="240" height="190">
			</td>
			<td align="center" width="250">
				<img alt="" src="img/center2.JPG" width="240" height="190">
			</td>
			<td align="center" width="250">
				<img alt="" src="img/center3.JPG" width="240" height="190">
			</td>
			<td align="center" width="250">
				<img alt="" src="img/center4.JPG" width="240" height="190">
			</td>
		</tr>
	</table>	

</body>
</html>