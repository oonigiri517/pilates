//予約フォームを動かすservlet
package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReserveData;


@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//フォワード先
		String forwardPath=null;

		String action=request.getParameter("action");

		if(action.equals("cancel")){
			//セッションスコープに保存
			HttpSession se=request.getSession();
			ReserveData reserveData=(ReserveData)se.getAttribute("reserveData");
			request.setAttribute("reserveData",reserveData);
		}
		forwardPath="/form.jsp";
		RequestDispatcher dis=request.getRequestDispatcher(forwardPath);
		dis.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String family_name=request.getParameter("family_name");
		String first_name=request.getParameter("first_name");
		String mail=request.getParameter("mail");
		String confMail=request.getParameter("confMail");
		String tel=request.getParameter("tel");
		String memo=request.getParameter("memo");

		String forwardPath=null;
		HashMap<String,String> ems = new HashMap<String,String>();


		//情報を設定
		ReserveData reserveData=new ReserveData(family_name,first_name,mail,confMail,tel,memo);


		//セッションスコープに保存
		HttpSession se=request.getSession();

		//入力チェック
		if(family_name ==null || family_name.length() ==0){
			ems.put("family_name","<br>"+"姓が未入力です");
		}
		if(first_name ==null || first_name.length() ==0){
			ems.put("first_name","<br>"+"名が未入力です");
		}
		if(mail ==null || mail.length() ==0){
			ems.put("mail","<br>"+"メールが未入力です");
		}else{
			Pattern pat = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
			Matcher m = pat.matcher(mail);

				if(!m.find()){
					ems.put("mail","<br>"+"書式が正しくありません");
			}
		}

		if(confMail ==null || confMail.length() ==0){
			ems.put("confMail","<br>"+"確認メールが未入力です");
		}else{
			if(!mail.equals(confMail)){
				ems.put("confMail","<br>"+"メールアドレスが一致しません");
			}else{
				Pattern pat = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
				Matcher m = pat.matcher(confMail);

					if(!m.find()){
						ems.put("confMail","<br>"+"書式が正しくありません");
				}
			}
		}

		if(tel !=null && tel.length()>1){
			Pattern pat = Pattern.compile("^0[0-9]{1,4}-?[0-9]{1,4}-?[0-9]{4}$");
			Matcher m = pat.matcher(tel);
			if(!m.find()){
				ems.put("tel","<br>"+"書式が正しくありません");
			}
		}


		if(ems.size() == 0){
			//データをセッションスコープに保存
			se.setAttribute("reserveData", reserveData);
			forwardPath = "/WEB-INF/jsp/formConfirm.jsp";
		}else{
			//ErrorBeans eb = new ErrorBeans();
			//eb.setEms(ems);
			request.setAttribute("ems", ems);
			request.setAttribute("reserveData", reserveData);
			//修正があるのでform.jspを再表示
			forwardPath = "/form.jsp";
		}


		//フォワード
		RequestDispatcher dis=request.getRequestDispatcher(forwardPath);
		dis.forward(request, response);
		}
	}


