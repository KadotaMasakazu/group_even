package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForPlaceNameGame {

	String InputWord = "";

	public void setUserInputWord() {
		String userInputWord = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String w = userInputWord;
			while (w != endcallLoop) {
				System.out.println("住所の一部を入力してください:");
				w = openInput.readLine();
				//正規表現で半角カタカナのみ受け付け
				Pattern acceptUserInput = Pattern.compile("^[｡-ﾟ]*$");
				Matcher matcher = acceptUserInput.matcher(w);
				boolean isConfirmInput = matcher.matches();
				if (isConfirmInput) {
					this.InputWord = w;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getUserInputWord() {
		return this.InputWord;
	}

}
