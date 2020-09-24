package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptUserInputForGetZipCode {
	String zipCode = "";

	public void setZipCode() {

		String userInputZipCode = "";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String z = userInputZipCode;
			while (z != AcceptUserInput.ENDCALLOFLOOP) {
				System.out.println("郵便番号を入力してください:"
						+ "(" + AcceptUserInput.ENDCALLOFLOOP + "で終了)");
				System.out.println("例:002-8026,0411622");
				z = openInput.readLine();

				//正規表現で郵便番号のみ受け付け
				if (AcceptUserInput.isEndCallWord(z)) {
					this.zipCode = z;
					break;
				}
				if (MatcherPatternForUserInput.isConfirmInputOfZipCode(z)) {
					this.zipCode = z;
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//TODO getterの引数は？
	public String getZipCode() {
		return this.zipCode;
	}
}
