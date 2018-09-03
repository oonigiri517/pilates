//使用前にメールアドレスとパスワード設定すること

package bo;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

import model.MailData;

public class SendMail {
	public boolean send(MailData mailData){

		String number = mailData.getNumber();
		String date = mailData.getDate();
		String time = mailData.getTime();
		String family_name = mailData.getFamily_name();
		String first_name = mailData.getFirst_name();
		String mail = mailData.getMail();

		String title="【"+date+"レッスン予約受付】Relax Pilates予約番号"+number;
		String text=family_name+"　"+first_name+"さま\n"
				+ "Relax Pilatesです。\n"
				+ "ご予約ありがとうございます。\n"
				+ date+"　"+time+"にてご予約承りました。\n"
				+ "\n"
				+ "キャンセルは2日前までにメールにてご連絡ください。\n"
				+ "予約番号"+number+"をメール本文に記載してください。\n"
				+ "当日は動きやすい服装、ドリンク500mm以上とタオルをご持参ください。\n"
				+ "ご質問、ご相談等、お気軽にお問い合わせください。\n"
				+ "\n"
				+ "問い合わせ先：relax.pilates123@gmail.com\n"
				+ "\n"
				+ "お会いできる日を楽しみにしています。\n"
				+ "\n";

		String toAddress=mail;//送信先アドレス

		String fromAddress="relax.pilates123@gmail.com";//送信元
		String password="relax321";//送信元のパスわード

		mailSend(title,text,toAddress,fromAddress,password);//パスワード
		return true;//時間があれば送信できてないか確認追加する
	}

	public static void mailSend(String title, String text, String toAddress,
		String fromAddress, String password) {

		try {
			// プロパティの設定
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props);
			Message msg = new MimeMessage(session);

			// 送信元メールアドレスのセット
			msg.setFrom(new InternetAddress(fromAddress));

			// 送信先メールアドレスのセット
			msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toAddress, false));

			// メールタイトル
			msg.setSubject(title);

			// メール本文
			msg.setText(text);

			// 送信日
			msg.setSentDate(new Date());

			// メール送信
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			try {
				t.connect("smtp.gmail.com", fromAddress, password);
				t.sendMessage(msg, msg.getAllRecipients());
			} finally {
				t.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
