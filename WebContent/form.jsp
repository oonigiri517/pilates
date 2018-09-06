<!-- 予約フォームの画面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.ReserveData,java.util.HashMap,model.Color"%>
<%
	//初期化
	String family_name = "";
	String first_name = "";
	String mail = "";
	String confMail = "";
	String tel = "";
	String memo = "";
	//スコープを取得
	ReserveData reserveData = (ReserveData) request.getAttribute("reserveData");
	if (reserveData != null) {
		family_name = reserveData.getFamily_name();
		first_name = reserveData.getFirst_name();
		mail = reserveData.getMail();
		confMail = reserveData.getConfMail();
		tel = reserveData.getTel();
		memo = reserveData.getMemo();
	}

	HashMap<String, String> ems = (HashMap<String, String>) request.getAttribute("ems");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ピラティススタジオ | Relax Pilates 予約フォーム</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link href="css/reset.css" type="text/css" rel="stylesheet" />
<link href="css/common.css" type="text/css" rel="stylesheet" />
<link href="css/menu.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/function.js"></script>

<jsp:include page="/menu.jsp" />
</head>
<style>
.error {
	color: #ff0000;
}

body {
	width: 100%; /*ページ全体の幅は100%と指定する*/
	/*text-align: center; /*ページ全体を中央揃えにする*/
}

#wrapper {
	margin-top: 5%;
	margin-bottom: 80px;
}

table {
	margin-left: auto;
	margin-right: auto;
}

td {
	background-color: #fff;
	text-align: left;
	padding: 10px 10px
}

th {
	background-color: <%=Color.getTableColor()%>;
	text-align: left;
	padding: 10px 10px
}

.button {
	display: inline-block;
	border-radius: 48%; /* 角丸       */
	font-size: 18pt; /* 文字サイズ */
	text-align: center; /* 文字位置   */
	cursor: pointer; /* カーソル   */
	padding: 11px 32px; /* 余白       */
	background: rgba(102, 226, 226, 0.76); /* 背景色     */
	color: #ffffff; /* 文字色     */
	line-height: 1em; /* 1行の高さ  */
	transition: .3s; /* なめらか変化 */
	box-shadow: 3px 3px 2px #666666; /* 影の設定 */
	border: 2px solid rgba(102, 226, 226, 0.76); /* 枠の指定 */
}

.button:hover {
	box-shadow: none; /* カーソル時の影消去 */
	color: rgba(102, 226, 226, 0.76); /* 背景色     */
	background: #ffffff; /* 文字色     */
}
/*h2{
		font-size:200%;
		}*/
</style>

<body>
	<div id="main">
		<div id="mainInner">
			<h2>
				<img src="images/menuTtl4.png" width="210" height="60"
					alt="Menu メニュー" />
			</h2>
		</div>
		<!-- #main -->
	</div>

	<div id="contentsArea" class="clearfix">

		<div id="contentsInner">

			<h3>
				<img src="images/subTtl5.png" width="560" height="40"
					alt="お客様情報を入力してください" />
			</h3>

			<div id="wrapper">


					<form action="/Pilates/Form" method="post">

						<table align="center">

							<tr>
								<th>姓</th>
								<td><input type="text" name="family_name" size="20"
									maxlength="20" value="<%=family_name%>" placeholder="山田">
									<span class="error"> <%
 	if (ems != null && ems.size() > 0) {
 		if (ems.containsKey("family_name")) {
 			out.print(ems.get("family_name"));
 		}
 	}
 %>
								</span><br></td>
							</tr>

							<tr>
								<th>名</th>
								<td><input type="text" name="first_name" size="20"
									maxlength="20" value="<%=first_name%>" placeholder="花子">
									<span class="error"> <%
 	if (ems != null && ems.size() > 0) {
 		if (ems.containsKey("first_name")) {
 			out.print(ems.get("first_name"));
 		}
 	}
 %>
								</span><br></td>
							</tr>

							<tr>
								<th>メールアドレス</th>
								<td><input type="text" name="mail" size="60"
									maxlength="100" value="<%=mail%>" placeholder="yamada@mail.com">
									<span class="error"> <%
 	if (ems != null && ems.size() > 0) {
 		if (ems.containsKey("mail")) {
 			out.print(ems.get("mail"));
 		}
 	}
 %>
								</span><br></td>
							</tr>

							<tr>
								<th>確認用メールアドレス

									<div style="font-size: small;">※コピー&ペーストNG</div>
								</th>
								<td><input type="text" oncopy="return false"
									onpaste="return false" oncontextmenu="return false"
									name="confMail" size="60" maxlength="100" value="<%=confMail%>"
									placeholder="yamada@mail.com"> <span class="error">
										<%
											if (ems != null && ems.size() > 0) {
												if (ems.containsKey("confMail")) {
													out.print(ems.get("confMail"));
												}
											}
										%>
								</span><br></td>
							</tr>

							<tr>
								<th>電話番号（任意）</th>
								<td><input type="text" name="tel" size="20" maxlength="20"
									value="<%=tel%>" placeholder="09012345678"> <span
									class="error"> <%
 	if (ems != null && ems.size() > 0) {
 		if (ems.containsKey("tel")) {
 			out.print(ems.get("tel"));
 		}
 	}
 %>
								</span><br></td>
							</tr>

							<tr>
								<th>備考（任意）</th>
								<td><textarea name="memo" cols="40" maxlength="200"
										placeholder="何でも書いてね♪"><%=memo%></textarea></td>
							</tr>
						</table>
				<br> <br>
				<div id="btm">
					<input type="submit" value="確認" class="button" text-align="center">
				</div>


				</form>

			</div>
			<!-- #contentsInner -->
		</div>
		<!-- #contentsArea -->
	</div>

	<footer>
		<jsp:include page="/footer.jsp" />
	</footer>
</body>
</html>