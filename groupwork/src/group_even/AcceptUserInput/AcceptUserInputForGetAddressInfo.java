package group_even_test.group_even.AcceptUserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInputForGetAddressInfo {

	String AddressInfo = "";

	public void setAddressInfo() {

		String userInputAddressInfo = "";
		String endcallLoop = "q";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			String ai = userInputAddressInfo;
			while (ai != endcallLoop) {
				System.out.println("住所の一部を入力してください:"
						+ "(" + endcallLoop + "で終了)");
				System.out.println("例:平岸,062");
				ai = openInput.readLine();

				//正規表現で住所情報のみ受け付け
				Pattern acceptUserInput = Pattern.compile("/w+|^q+");
				Matcher matcher = acceptUserInput.matcher(ai);
				boolean isConfirmInput = matcher.matches();
				if (AcceptUserInput.isEndCallWord(ai)) {
					System.out.println("終了します");
					this.AddressInfo = ai;
					break;
				}
				if (isConfirmInput) {
					this.AddressInfo = ai;

				} else {
					System.out.println("例に沿った形で入力してください");
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getAddressInfo() {
		return this.AddressInfo;
	}
}
