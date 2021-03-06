<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ピラティススタジオ | Relax Pilates</title>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link href="css/reset.css" type="text/css" rel="stylesheet" />
	<link href="css/common.css" type="text/css" rel="stylesheet" />
	<link href="css/menu.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>

	<jsp:include page="/menu.jsp"/>
</head>
<body>
		<div id="main">
			<div id="mainInner">
				<h2><img src="images/menuTtl2.png" width="210" height="60" alt="Menu メニュー" /></h2>
			</div>
		<!-- #main --></div>

		<div id="contentsArea" class="clearfix">

			<div id="contentsInner">

				<h3><img src="images/subTtl1.png" width="560" height="40" alt="レッスン内容" /></h3>
				<p id="box1">
				・1レッスン45分　Max定員2名のプライベート空間です。<br>
				・始めてでも安心してレッスンを受けていただけます。<br>
				・通いやすい回数券もご用意しています。<br><br><br>
				*Traial：初回限定
				*1 lesson：都度払い
				*4 lesson：4回回数券

				</p>
				<br><br><br><br><br>


				<h3><img src="images/subTtl2.png" width="560" height="40" alt="価格表" /></h3>

			<div id=table align="center">
				<table border="1" cellspacing="0" align="center">
					<tr style="background-color:#F0F7F9;font-weight:bold;">
						<td style="padding: 8px;text-align:center;font-size:20px;">Trial lesson</td>
						<td style="padding: 8px; text-align:center;font-size:20px;">1 lesson</td>
						<td style="padding: 8px; text-align:center;font-size:20px;">4 lesson</td>
					</tr>
					<tr style="background-color:#F0F7F9;font-weight:bold;">
						<td style="padding: 8px; text-align:center;font-size:20px;">2,500 yen</td>
						<td style="padding: 8px; text-align:center;font-size:20px;">3,000 yen</td>
						<td style="padding: 8px; text-align:center;font-size:20px;">11,000 yen</td>
					</tr>
				</table>
			</div>

				</div>
				</div>

<footer>
<jsp:include page="/footer.jsp"/>
</footer>
</body>

</html>