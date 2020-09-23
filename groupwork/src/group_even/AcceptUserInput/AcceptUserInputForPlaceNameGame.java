package group_even_test.group_even.AcceptUserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForPlaceNameGame {

	String placeName = "";

	public void setPlaceName() {
		String userInputWord = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String w = userInputWord;
			while (w != endcallLoop) {
				System.out.println("次の地名のよみがなを半角カタカナで入力してください。"
						+ "(" + endcallLoop + "で終了):");
				w = openInput.readLine();
				//正規表現で半角カタカナのみ受け付け
				Pattern acceptUserInput = Pattern.compile("^[｡-ﾟ]*$|^q+");
				Matcher matcher = acceptUserInput.matcher(w);
				boolean isConfirmInput = matcher.matches();
				if (AcceptUserInput.isEndCallWord(w)) {
					System.out.println("終了します");
					this.placeName = w;
					break;
				}
				if (isConfirmInput) {
					this.placeName = w;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getPlaceName() {
		return this.placeName;
	}

}
