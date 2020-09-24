package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForPlaceNameGame {

	String placeName = "";

	public void setPlaceName() {
		String userInputWord = "";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String w = userInputWord;
			while (w != AcceptUserInput.ENDCALLOFLOOP) {
				System.out.println("次の地名のよみがなを半角カタカナで入力してください。"
						+ "(" + AcceptUserInput.ENDCALLOFLOOP + "で終了):");
				w = openInput.readLine();
				//正規表現で半角カタカナのみ受け付け
				Pattern acceptUserInput = Pattern.compile("^[｡-ﾟ]*$|^q+");
				Matcher matcher = acceptUserInput.matcher(w);
				boolean isConfirmInput = matcher.matches();
				if (AcceptUserInput.isEndCallWord(w)) {
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
