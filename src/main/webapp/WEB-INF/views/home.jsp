<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<c:import url="./temp/boot_head.jsp"></c:import>
	<script type="text/javascript">
		alert('Hello world');
	</script>
	<link href="./resources/css/home.css" rel="stylesheet">
</head>
<body>
<c:import url="./temp/boot_nav.jsp"></c:import>
<h1 class="c1">
	Hello world!  
</h1>

<h1 id="d1">
	Other H1
</h1>

<div id="d2">
<h3 id="d1">In DIV</h3>
</div>


<img  id="d3" class="c1" src="./resources/images/joy.jpg">

<div>
	<button onClick="fn1()">CLICK</button>
</div>

<script type="text/javascript">
	console.log('body Script');
</script>
<!-- <script type="text/javascript" src="./resources/js/home.js">
</script> -->
<script type="text/javascript" src="./resources/js/function_1.js"></script>
</body>
</html>
