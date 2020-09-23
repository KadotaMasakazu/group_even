package group_even_test.group_even.AcceptUserInput;

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
			//1～5の番号ごとにインスタンスを生成して入力用メソッドに渡す
			while (!isEndCallWord(u)) {
				System.out.println("1～5の数値を入力してください:(" + endcallLoop + "で終了)");
				showIndroduction();
				u = openInput.readLine();

				//正規表現（1～5）のみを受け付けている。
				Pattern acceptUserInput = Pattern.compile("^[1-5]+");
				Matcher matcher = acceptUserInput.matcher(u);
				boolean isConfirmInput = matcher.matches();
				if (isEndCallWord(u)) {
					System.out.println("終了します");
					break;
				}
				//1～5を場合分けしたのち入力用メソッドへ受け渡し
				if (isConfirmInput) {
					switch (u) {
					case "1":
						AcceptUserInputForGetZipCode menu1 = new AcceptUserInputForGetZipCode();
						menu1.setZipCode();
						if (isEndCallWord(menu1.getZipCode())) {
							break;
						}
						//担当のクラスを挿入
						OutputAddressFromZipCode outputFromMenu1 = new OutputAddressFromZipCode();
						outputFromMenu1.setZipCode(menu1.getZipCode());
						outputFromMenu1.outputAddress();
						break;
					case "2":
						AcceptUserInputForGetAddressInfo menu2 = new AcceptUserInputForGetAddressInfo();
						menu2.setAddressInfo();
						if (isEndCallWord(menu2.getAddressInfo())) {
							break;
						}
						break;
					case "3":
						//TODO 地名よみがな当てゲームのクラスに直接渡すべき？
						//Userが入力するメソッドだけ用意しておきました。
						//0923 利便性の面から担当者のクラスのみで運用。
						GetAddressFromKeyword menu3 = new GetAddressFromKeyword();
						menu3.getAddressFromUsetInputtedKeyword();
						break;

					case "4":
						AcceptUserInputForAddressBook menu4 = new AcceptUserInputForAddressBook();
						menu4.setPersonalInfo();
						if (isEndCallWord(menu4.getPersonalInfo())) {
							break;
						}
						//担当のクラスを挿入
						AddressBook outputFromMenu4 = new AddressBook();
						outputFromMenu4.setPersonalInfo(menu4.getPersonalInfo());
						outputFromMenu4.registerToAddressBook();
						break;
					case "5":
						//TODO オリジナルの仕様が判明次第追加
						break;
					}
					break;//endWhile
				} else {
					System.out.println("１～５以外の値が入力されたため戻ります。");
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
	}

	public static boolean isEndCallWord(String userInput) {

		if(userInput.equals("q")||userInput.equals("ｑ")) {
		return true;
		}
		return false;

	}
}
