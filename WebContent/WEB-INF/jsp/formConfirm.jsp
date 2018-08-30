<!-- 確認画面(行く先はReserve.java(servlet)) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReserveData" %>
<%
ReserveData reserveData=(ReserveData) session.getAttribute("reserveData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
<style>

		body{
				  width:100%; /*ページ全体の幅は100%と指定する*/
				  text-align:center; /*ページ全体を中央揃えにする*/
				}

		table{
			margin-left:auto;
			margin-right:auto;
		}

		td{
			background-color:#fff;
			text-align:left;

			padding:10px 10px
		}

		th{
			background-color:#c6ecf2;
			text-align:left;
			padding:10px 10px
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
<br>
<br>
<a href="/Pilates/Form?action=cancel">キャンセル</a>
<br>
<input type="submit" value="確定" class="button">

</form>


</body>
</html>