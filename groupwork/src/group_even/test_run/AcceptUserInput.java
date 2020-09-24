package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptUserInput {

	static final String ENDCALLOFLOOP = "q";

	public void inputReception() {

		String userInput = "";

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {

			String ui = userInput;
			// 1～5の番号ごとにインスタンスを生成して入力用メソッドに渡す
			while (!isEndCallWord(ui)) {
				System.out.println("1～5の数値を入力してください:(" + ENDCALLOFLOOP + "で終了)");
				showIndroduction();
				ui = openInput.readLine();
				if (isEndCallWord(ui)) {
					break;
				}
				// 1～5を場合分けしたのち入力用メソッドへ受け渡し
				// ifの()正規表現メソッドへ受け渡し
				if (MatcherPatternForUserInput.isConfirmInputOfMenuNumber(ui)) {
					switch (ui) {
					case "1":
						AcceptUserInputForGetZipCode menu1 = new AcceptUserInputForGetZipCode();
						menu1.setZipCode();
						if (isEndCallWord(menu1.getZipCode())) {
							break;
						}
						// 担当のクラスを挿入
						AddressFromZipCode outputFromMenu1 = new AddressFromZipCode();
						outputFromMenu1.setZipCode(menu1.getZipCode());
						outputFromMenu1.getAddressFromZipCode();
						break;
					case "2":
						PlaceNameSearch_ArrayForGetAddressInfo menu2 = new PlaceNameSearch_ArrayForGetAddressInfo();
						menu2.getAddressFromUserInputAddressPartialInfo();
						if (isEndCallWord(menu2.getPlace_name())) {
							break;
						}
						break;
					case "3":
						// 0923 利便性の面から担当者のクラスのみで運用。
						GetAddressKeyWord_ArrayForPlaceNameGame menu3 = new GetAddressKeyWord_ArrayForPlaceNameGame();
						menu3.getAddressFromUsetInputtedKeyword();
						break;

					case "4":
						AcceptUserInputForAddressBook menu4 = new AcceptUserInputForAddressBook();
						menu4.setPersonalInfo();
						if (isEndCallWord(menu4.getPersonalInfo())) {
							break;
						}
						// 担当のクラスを挿入 0924完成まち
						AddressBook outputFromMenu4 = new AddressBook();
						outputFromMenu4
								.setPersonalInfo(menu4.getPersonalInfo());
						outputFromMenu4.registerToAddressBook();
						break;
					case "5":
						//利便性の面から利便性の面から担当者のクラスのみで運用。
						Original_MainForMenu5 menu5 = new Original_MainForMenu5();
						menu5.startAppOfOriginal();
						break;
					}
					break;// endWhile
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showIndroduction() {
		System.out.println("1:郵便番号から住所を検索します。");
		System.out.println("2:住所の一部を元に合致するものを検索します。");
		System.out.println("3:地名よみがな当てゲーム");
		System.out.println("4:個人情報をAddressBook.csvに登録します。");
		System.out.println("5:オリジナルクラス。");
		System.out.print(":");
	}

	public static boolean isEndCallWord(String userInput) {

		if (userInput.equals("q") || userInput.equals("ｑ")) {
			return true;
		}
		return false;

	}
}
