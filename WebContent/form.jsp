<!-- 予約フォームの画面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReserveData,java.util.HashMap,model.Color" %>
<%
//初期化
	String family_name="";
	String first_name="";
	String mail="";
	String confMail="";
	String tel="";
	String memo="";
	//スコープを取得
	ReserveData reserveData=(ReserveData) request.getAttribute("reserveData");
	if(reserveData != null){
		family_name=reserveData.getFamily_name();
		first_name=reserveData.getFirst_name();
		mail=reserveData.getMail();
		confMail=reserveData.getConfMail();
		tel=reserveData.getTel();
		memo=reserveData.getMemo();
	}

	HashMap<String,String> ems = (HashMap<String,String>)request.getAttribute("ems");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>予約フォーム</title>
<style>
		.error{
			color:#ff0000;
		}


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
			background-color:<%= Color.getTableColor()%>;
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
<h1>予約フォーム</h1>
<h2>お客様の情報をご入力ください</h2>


<form action="/Pilates/Form" method="post">

<table>

<tr>
<th>姓</th>
<td><input type="text" name="family_name"  size="20" maxlength="20"
value="<%= family_name %>" placeholder="増田">
<span class="error">
<%
if(ems != null && ems.size()>0){
	if(ems.containsKey("family_name")){
		out.print(ems.get("family_name"));
	}
}
%>
</span><br>
</td>
</tr>

<tr>
<th>名</th>
<td>
<input type="text" name="first_name"  size="20" maxlength="20"
value="<%= first_name %>" placeholder="姫">
<span class="error">
<%
if(ems != null && ems.size()>0){
	if(ems.containsKey("first_name")){
		out.print(ems.get("first_name"));
	}
}
%>
</span><br>
</td>
</tr>

<tr>
<th>メールアドレス</th>
<td>
<input type="text" name="mail"  size="60" maxlength="100" value="<%= mail %>" placeholder="relax.pilates123@gmail.com">
<span class="error">
<%
if(ems != null && ems.size()>0){
	if(ems.containsKey("mail")){
		out.print(ems.get("mail"));
	}
}
%>
</span><br>
</td>
</tr>

<tr>
<th>確認用メールアドレス

<div style="font-size:small;">※コピー&ペーストNG</div>
</th>
<td>
<input type="text"  oncopy="return false" onpaste="return false" oncontextmenu="return false" name="confMail"
size="60" maxlength="100"  value="<%= confMail %>" placeholder="relax.pilates123@gmail.com">
<span class="error">
<%
if(ems != null && ems.size()>0){
	if(ems.containsKey("confMail")){
		out.print(ems.get("confMail"));
	}
}
%>
</span><br>
</td>
</tr>

<tr>
<th>電話番号（任意）</th>
<td>
<input type="text" name="tel"  size="20" maxlength="20"
value="<%= tel %>" placeholder="09012345678">
</td>
</tr>

<tr>
<th>備考（任意）</th>
<td>
<textarea name="memo"  cols="40"  maxlength="200"
placeholder="何でも書いてね♪"><%= memo %></textarea>
</td>
</tr>
</table>
<br>
<br>

<br>
<input type="submit" value="確認" class="button">


</form>


</body>
</html>