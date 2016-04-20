<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<script src="<c:url value="/resources/js/angular.js" />"></script>
<title>Home</title>
</head>
<body style="background-color: gray;">

<%@include file="menu.jsp"%>
	<h1>
		Hello world!
		<c:out value="${sessionScope.user.firstName}"></c:out>
	</h1>
	<P>The time on the server is ${serverTime}.</P>

	<div class="container" style="width:450px; height: 450px;">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 hidden-xs">
				<div id="carousel-299058" class="carousel slide">
					<ol class="carousel-indicators">
						<li data-target="#carousel-299058" data-slide-to="0" class="">
						</li>
						<li data-target="#carousel-299058" data-slide-to="1"
							class="active"></li>
						<li data-target="#carousel-299058" data-slide-to="2" class="">
						</li>
					</ol>
					<div class="carousel-inner">
						<div class="item">
							<img style="width: 450px; height: 450px;" class="img-responsive"
								src="<c:url value="/resources/images/carousel1.jpg"/>"
								alt="thumb">
							<div class="carousel-caption">Share Food</div>
						</div>
						<div class="item active">
							<img style="width: 450px; height: 450px;" class="img-responsive"
								src="<c:url value="/resources/images/carousel3.jpg"/>"
								alt="thumb">
							<div class="carousel-caption">Indian Food Too</div>
						</div>
						<div class="item">
							<img style="width: 450px; height: 450px;" class="img-responsive"
								src="<c:url value="/resources/images/carousel2.jpg"/>"
								alt="thumb">
							<div class="carousel-caption">Click and Upload</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-299058"
						data-slide="prev"><span class="icon-prev"></span></a> <a
						class="right carousel-control" href="#carousel-299058"
						data-slide="next"><span class="icon-next"></span></a>
				</div>
			</div>
		</div>
		<hr>
	</div>
	<div style="background-color: white;">
	<%@include file="footer.jsp"%>
	</div>
</body>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	
</html>
