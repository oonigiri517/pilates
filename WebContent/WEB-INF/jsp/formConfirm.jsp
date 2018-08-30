<!-- 確認画面(行く先はReserve.java(servlet)) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReserveData,model.Color" %>
<%
ReserveData reserveData=(ReserveData) session.getAttribute("reserveData");
Color color=new Color();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<style>

		body{
				  width:100%; /*ページ全体の幅は100%と指定する*/
				  /*ページ全体を中央揃えにする*/
				}

		div{
			width:600px;

			margin:0 auto;
			text-align:center;
		}

		table{
			background-color:<%= color.getTableColor()%>;
			margin-left:auto;
			margin-right:auto;
			width:600px;
		}

		td{
			background-color:#fff;
			text-align:left;
			padding:10px 10px;
			width:400px
		}

		th{
			background-color:#fff;
			text-align:left;
			padding:10px 10px
		}

		.modoru{
			text-align:right;
		}

		a{
			text-decoration:none;
		}

		.button {
				  display       : inline-block;
				  border-radius : 48%;          /* 角丸       */
				  font-size     : 18pt;        /* 文字サイズ */
				  text-align    : center;      /* 文字位置   */
				  cursor        : pointer;     /* カーソル   */
				  padding       : 11px 32px;   /* 余白       */
				  background    : rgba(102, 226, 226, 0.76);     /* 背景色     */
				  color         : #ffffff;     /* 文字色     */
				  line-height   : 1em;         /* 1行の高さ  */
				  transition    : .3s;         /* なめらか変化 */
				  box-shadow    : 3px 3px 2px #666666;  /* 影の設定 */
				  border        : 2px solid rgba(102, 226, 226, 0.76);    /* 枠の指定 */
				}
		.button:hover {
				  box-shadow    : none;        /* カーソル時の影消去 */
				  color         : rgba(102, 226, 226, 0.76);     /* 背景色     */
				  background    : #ffffff;     /* 文字色     */
				}





</style>
</head>
<body>
<div>
<h1>確認画面</h1>


<form action="#" method="post">

<table>
<tr>
<th>姓</th>
<td><%=reserveData.getFamily_name() %></td>
</tr>

<tr>
<th>名</th>
<td><%=reserveData.getFirst_name() %></td>
</tr>

<tr>
<th>メールアドレス</th>
<td><%=reserveData.getMail() %></td>
</tr>

<tr>
<th>確認用</th>
<td><%=reserveData.getConfMail() %></td>
</tr>

<tr>
<th>電話番号</th>
<td><%=reserveData.getTel() %></td>
</tr>

<tr>
<th>備考</th>
<td><%=reserveData.getMemo() %></td>
</tr>
</table>

<p class="modoru">
<a href="/Pilates/Form?action=cancel" >キャンセル</a>
</p>

<input type="submit" value="確定" class="button">

</form>

</div>
</body>
</html>