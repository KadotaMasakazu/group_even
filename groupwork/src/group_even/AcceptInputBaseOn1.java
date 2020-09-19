package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptInputBaseOn1 {

	public static String getZipCode() {

		String zipCode = "";
		String userInputZipCode = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String z = userInputZipCode;
			while (z != endcallLoop) {
				System.out.println("郵便番号を入力してください:"
						+ "(" + endcallLoop + "で終了)");
				System.out.println("例:002-8026,0411622");
				if (z.equals(endcallLoop)) {
					System.out.println("終了します");
					break;
				}
				//正規表現で郵便番号のみ受け付け
				Pattern acceptUserInput = Pattern.compile("^[0-9]{3}-[0-9]{4}$|^/d{7}$");
				Matcher matcher = acceptUserInput.matcher(z);
				boolean isConfirmInput = matcher.matches();
				if (isConfirmInput) {
					zipCode = z;

				} else {
					System.out.println("例に沿った形で郵便番号を入力してください");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zipCode;
	}
}
