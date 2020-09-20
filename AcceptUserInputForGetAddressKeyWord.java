package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForGetAddressKeyWord {

	String KeyWord = "";

	public String getKeyWord() {

		String userInputKeyWord = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String k = userInputKeyWord;
			while (k != endcallLoop) {
				System.out.println("住所の一部を入力してください:"
						+ "(" + endcallLoop + "で終了)");
				System.out.println("例:平岸,062");
				if (k.equals(endcallLoop)) {
					System.out.println("終了します");
					break;
				}
				//正規表現で住所情報のみ受け付け
				Pattern acceptUserInput = Pattern.compile("/w+");
				Matcher matcher = acceptUserInput.matcher(k);
				boolean isConfirmInput = matcher.matches();
				if (isConfirmInput) {
					KeyWord = k;

				} else {
					System.out.println("例に沿った形で入力してください");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}
}
