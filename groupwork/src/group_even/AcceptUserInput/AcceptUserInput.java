package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcceptUserInput {

	public void inputReception() {

		String userInput = "";
		String []endcallLoop = {"q","ｑ"};

		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {

			String u = userInput;
			//1～5の番号ごとにインスタンスを生成して入力用メソッドに渡す
			while (u != endcallLoop[0]||u !=endcallLoop[1]) {
				System.out.print("1～5の数値を入力してください:(" + endcallLoop[0] + "で終了)");
				u = openInput.readLine();
				if (u.equals(endcallLoop[0])||u.equals(endcallLoop[1])) {
					System.out.println("終了します");
					break;
				}
				//正規表現（1～5）のみを受け付けている。
				Pattern acceptUserInput = Pattern.compile("^[1-5]+");
				Matcher matcher = acceptUserInput.matcher(u);
				boolean isConfirmInput = matcher.matches();
				//1～5を場合分けしたのち入力用メソッドへ受け渡し
				if (isConfirmInput) {
					switch (u) {
					case "1":
						AcceptUserInputForGetZipCode menu1 =
						                     new AcceptUserInputForGetZipCode();
						menu1.getZipCode();
						break;
					case "2":
						AcceptUserInputForGetAddressKeyWord menu2 =
						                            new AcceptUserInputForGetAddressKeyWord();
						menu2.getKeyWord();
						break;
					case "3":
						//TODO 地名よみがな当てゲームのクラスに直接渡すべき？
						//Userが入力するメソッドだけ用意しておきました。
						break;
					case "4":
						AcceptUserInputForAddressBook menu4 =
						                              new AcceptUserInputForAddressBook();
						menu4.getPersonalInfo();
						break;
					case "5":
						//TODO オリジナルの仕様が判明次第追加
						break;
					}
					u = endcallLoop[0];//endWhile
				} else {
					System.out.println("１～５以外の値が入力されたため戻ります。");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
