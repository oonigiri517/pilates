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
	<link href="./css/reset.css" type="text/css" rel="stylesheet" />
	<link href="./css/common.css" type="text/css" rel="stylesheet" />
	<link href="./css/top.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/infiniteslide.js"></script>
	<script type="text/javascript" src="js/jquery.pause.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>
	<script type="text/javascript">
	$(function() {
		$('.infiniteslide1').infiniteslide({
			'height': 470, //高さ
			'speed': 30, //速さ
			'direction': 'left', //向き
			'pauseonhover': false //マウスオーバーでストップ
		});
	});
	</script>

<jsp:include page="/menu.jsp"/>
</head>

<body>
		<div id="main" class="infiniteslide1">
			<ul>
				<li><img src="images/main01.jpg" width="700" height="470" alt="" /></li>
				<li><img src="images/main02.jpg" width="700" height="470" alt="" /></li>
				<li><img src="images/main03.jpg" width="700" height="470" alt="" /></li>
			</ul>
		<!-- #main --></div>


		<div id="contentsArea" class="clearfix">

			<div id="contentsInner">

				<p id="illust03"><img src="images/illust03.png" width="200" height="160" alt="" /></p>

				<div id="intro">
					<h2><img src="images/introTtl.png" width="640" height="120" alt="" /></h2>
					<p>Relax Pilates リラックスピラティスは兵庫県明石市の少人数制スタジオです。</p>
				<!-- #intro --></div>




				<div id="newsblog" class="clearfix">
					<div id="news">
						<h3><img src="images/newsTtl.png" width="460" height="50" alt="サロンからのお知らせ" /></h3>
						<ul>
							<li><span>2018.09.01</span><a href="" class="mouseHvr">食欲の秋！食べ過ぎ対策キャンペーンを開始</a></li>
							<li><span>2018.08.25</span><a href="" class="mouseHvr">9月の定休日についてのご案内</a></li>
							<li><span>2018.08.01</span><a href="" class="mouseHvr">猛暑対策！夏バテ防止キャンペーンを開始</a></li>
							<li><span>2018.07.01</span><a href="" class="mouseHvr">サイトオープン</a></li>
						</ul>
					<!-- #news --></div>


									<!-- #newsandblog --></div>


												<!-- #block --></div>
									<div id="block" class="clearfix">

								<!-- #contentsInner --></div>

							<!-- #contentsArea --></div>


		<div id="pageTop">
			<p class="mouseHvr"><a href="#"><img src="images/pageTop.png" width="95" height="100" alt="PageTop" /></a></p>
		<!-- #pageTop --></div>

<footer>
<jsp:include page="/footer.jsp"/>
</footer>
</body>

</html>