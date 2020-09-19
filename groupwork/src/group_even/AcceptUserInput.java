package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInput {

	public void inputReception() {

		String userInput = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {

			String u = userInput;
			while (u != endcallLoop) {
				System.out.print("1～5の数値を入力してください:(" + endcallLoop + "で終了)");
				u = openInput.readLine();
				if (u.equals(endcallLoop)) {
					System.out.println("終了します");
					break;
				}
				//正規表現（1～5）のみを受け付けている。
				Pattern acceptUserInput = Pattern.compile("^[1-5]+");
				Matcher matcher = acceptUserInput.matcher(u);
				boolean isConfirmInput = matcher.matches();
				//1～5を場合分け
				if (isConfirmInput) {
					switch (u) {
					case "1":
						AcceptInputBaseOn1.getZipCode();
						break;
					case "2":
						AcceptInputBaseOn2.getKeyWord();
						break;
					case "3":
						selectedMenuNum = "3";
						break;
					case "4":
						selectedMenuNum = "4";
						break;
					case "5":
						selectedMenuNum = "5";
						break;
					}
					u = endcallLoop;//endWhile
				}else {
					System.out.println("１～５以外の値が入力されたため戻ります。");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
