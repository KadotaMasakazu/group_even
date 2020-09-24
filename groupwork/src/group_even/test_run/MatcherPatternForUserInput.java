package group_even;

import java.util.regex.Pattern;

public class MatcherPatternForUserInput {

	// ユーザーからの入力を正規表現で判定するstaticクラス。
	// 正規表現以外の時は再度入力を促す。

	// ユーザーの入力がメニュー数にあっているか判定する(AcceptUserInput)
	public static boolean isConfirmInputOfMenuNumber(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[1-5]+|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("１～５以外の値が入力されたため戻ります。");
			return false;
		}
	}

	// ユーザーが郵便番号の形式に合致しているか判定する(AcceptUserInputForGetZipCode)
	public static boolean isConfirmInputOfZipCode(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[0-9]{3}-?[0-9]{4}|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("例に沿った形で郵便番号を入力してください");
			return false;
		}
	}

	// ユーザーが住所情報の形式に合致しているか判定する(AcceptUserInputForGetAddressInfo)
	public static boolean isConfirmInputOfAddressPartialInfo(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[ぁ-んー]+$|^[0-9]+$|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("例に沿った形で入力してください");
			return false;
		}
	}

	// ユーザーが半角カタカナに合致しているか判定する(GetAddressKeyword)
	public static boolean isConfirmInputOfHalfwidthKatakana(String userInput) {
		boolean isConfirmInput = Pattern.matches("^[ｦ-ﾟ]+$|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("半角カタカナで入力してください");
			return false;
		}

	}

	// 以下AcceptUserInputForAddressBook[個人情報]郵便番号はかぶり用

	public static boolean isConfirmInputOfPersonName(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[^!-~｡-ﾟ]+$|^q+", userInput);

		//再入力をもとめるif
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("全角のみで入力を行ってください");
			return false;
		}
	}

	public static boolean isConfirmInputOfFullwidthHiragana(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[^/u3040-u309F]+$|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("全角ひらがなのみで入力を行ってください");
			return false;
		}
	}

	public static boolean isConfirmInputOf1OR2(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[1-2]+$|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("正しく性別IDが入力されていません");
			return false;
		}

	}

	public static boolean isConfirmInputOfPhoneNumber(String userInput) {

		boolean isConfirmInput = Pattern.matches("^0[789]0(-\\d{4}-\\d{4}|\\d{8})$|" + "^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("例に沿った形で電話番号を入力してください");
			return false;
		}
	}

	public static boolean isConfirmInputOfEmailAddress(String userInput) {
		boolean isConfirmInput = Pattern
				.matches("^[\\\\w!#%&'/=~`\\\\*\\\\+\\\\?\\\\{\\\\}\\\\^\\\\$\\\\-\\\\|]+\"\r\n" +
						"(\\\\.[\\\\w!#%&'/=~`\\\\*\\\\+\\\\?\\\\{\\\\}\\\\^\\\\$\\\\-\\\\|]+)*@\"\r\n" +
						"[\\\\w!#%&'/=~`\\\\*\\\\+\\\\?\\\\{\\\\}\\\\^\\\\$\\\\-\\\\|]+\"\r\n" +
						"(\\\\.[\\\\w!#%&'/=~`\\\\*\\\\+\\\\?\\\\{\\\\}\\\\^\\\\$\\\\-\\\\|]+)*$\"\r\n" +
						"|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("例に沿った形でメールアドレスを入力してください");
			return false;
		}
	}

	public static boolean isConfirmInputOfAreaID(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[0-10]|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("1から10の数字を入力してください");
			return false;
		}
	}
	public static boolean isConfirmInputOfSortingID(String userInput) {

		boolean isConfirmInput = Pattern.matches("^[0-6]|^q+", userInput);
		if (isConfirmInput) {
			return true;
		} else {
			System.out.println("1から6の数字を入力してください");
			return false;
		}
	}
}
