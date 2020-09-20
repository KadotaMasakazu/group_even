package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForPlaceNameGame {

	String userInputWord = "";

	public String getUserInputWord() {

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {

			String W = userInputWord;
			//正規表現で半角カタカナのみ受け付け
			Pattern acceptUserInput = Pattern.compile("^[｡-ﾟ]*$");
			Matcher matcher = acceptUserInput.matcher(W);
			boolean isConfirmInput = matcher.matches();
			if (isConfirmInput) {
				userInputWord = W;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInputWord;
	}

	public void setUserInputWord(String userInputWord) {
		this.userInputWord = userInputWord;
	}

}
