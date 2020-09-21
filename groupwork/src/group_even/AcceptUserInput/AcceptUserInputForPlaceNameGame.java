package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForPlaceNameGame {

	String userInputWord = "";

	public void setUserInputWord() {

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String w = userInputWord;
			System.out.println("郵便番号を入力してください:");
			w = openInput.readLine();
			//正規表現で半角カタカナのみ受け付け
			Pattern acceptUserInput = Pattern.compile("^[｡-ﾟ]*$");
			Matcher matcher = acceptUserInput.matcher(w);
			boolean isConfirmInput = matcher.matches();
			if (isConfirmInput) {
				this.userInputWord = w;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getUserInputWord() {
		return this.userInputWord;
	}

}
