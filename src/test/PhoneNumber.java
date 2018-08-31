package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

	public static void main(String[] args) {
		String phoneNumber = "06-6449-1177";
		Pattern pat = Pattern.compile("^0[0-9]{1,4}-[0-9]{1,4}-[0-9]{4}$");
		Matcher m = pat.matcher(phoneNumber);

		if(m.find()){
			System.out.println("正しい電話番号書式です");
		}else{
			System.out.println("誤った電話番号書式です");
		}
	}

}
