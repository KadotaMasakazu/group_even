package group_even_test.group_even.AcceptUserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForGetZipCode {
	String zipCode = "";

	public void setZipCode() {

		String userInputZipCode = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String z = userInputZipCode;
			while (z != endcallLoop) {
				System.out.println("郵便番号を入力してください:"
						+ "(" + endcallLoop + "で終了)");
				System.out.println("例:002-8026,0411622");
				z = openInput.readLine();

				//正規表現で郵便番号のみ受け付け
				Pattern acceptUserInput = Pattern.compile("^[0-9]{3}-?[0-9]{4}|^q+");
				Matcher matcher = acceptUserInput.matcher(z);
				boolean isConfirmInput = matcher.matches();
				if (z.equals(endcallLoop)) {
					System.out.println("終了します");
					this.zipCode = z;
					break;
				}
				if (isConfirmInput) {
					this.zipCode = z;
					break;
				} else {
					System.out.println("例に沿った形で郵便番号を入力してください");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getZipCode() {
		return this.zipCode;
	}
}
