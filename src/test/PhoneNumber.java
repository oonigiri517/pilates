//電話番号正規表現
//メール正規表現
package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {

	public static void main(String[] args) {
		String phoneNumber = "06-6449-1179";
		//^は始まりって意味、$は終わりって意味
		//{1,4}←1～4回繰り返せるよってこと
		//?←個数が0でも１でもOK
		Pattern pat = Pattern.compile("^0[0-9]{1,4}-?[0-9]{1,4}-?[0-9]{4}$");
		Matcher m = pat.matcher(phoneNumber);
//^[\w!#%&'/=~`\*\+\?\{\}\^\$\-\|]+(\.[\w!#%&'/=~`\*\+\?\{\}\^\$\-\|]+)*@[\w!#%&'/=~`\*\+\?\{\}\^\$
		if(m.find()){
			System.out.println("正しい電話番号書式です");
		}else{
			System.out.println("誤った電話番号書式です");
		}
	}

}
