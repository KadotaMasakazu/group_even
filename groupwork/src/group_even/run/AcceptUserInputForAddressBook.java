package group_even;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcceptUserInputForAddressBook {

	private String personalInfo = "";
	private String isEndOfMenu4 = "";

	public String getIsEndOfMenu4() {
		return isEndOfMenu4;
	}

	public void setIsEndOfMenu4(String isEndOfMenu4) {
		this.isEndOfMenu4 = isEndOfMenu4;
	}

	//各個人情報をUserに入力させ,personalInfoに","込みで出力
	public void setPersonalInfo() {
		String personName = "";
		String readName = "";
		String sexID = "";
		String zipCode = "";
		String address = "";
		String phoneNumber = "";
		String emailAddress = "";
		String areaID = "";
		String sortingID = "";


		try (BufferedReader openInput = new BufferedReader(
				new InputStreamReader(System.in))) {
			loop_startInputPersonalInfo: while (true) {

				System.out.println("入力は"+AcceptUserInput.ENDCALLOFLOOP+"で終了します。");
				//名前を取得
				for (int inputPersonalName = 0; inputPersonalName < 1; inputPersonalName++) {
					System.out.print("名前(全角)を入力してください。:");
					personName = openInput.readLine();

					//正規表現で全角とqのみ受付
					if (AcceptUserInput.isEndCallWord(personName)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					//再度入力
					if (!MatcherPatternForUserInput.isConfirmInputOfPersonName(personName)) {
						inputPersonalName--;
					}

				}

				//入力された名前の読み仮名を取得
				for (int inputHowToReadName = 0; inputHowToReadName < 1; inputHowToReadName++) {
					System.out.print("読み仮名(ひらがな)を入力してください。:");
					readName = openInput.readLine();

					//正規表現で全角ひらがなとqのみ受付
					if (AcceptUserInput.isEndCallWord(readName)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					//再度入力
					if (!MatcherPatternForUserInput.isConfirmInputOfFullwidthHiragana(readName)) {
						inputHowToReadName--;
					}

				}

				//性別情報を取得
				for (int inputSexID = 0; inputSexID < 1; inputSexID++) {
					System.out.print("性別ID(半角数字)を入力してください。1:男性2:女性:");
					sexID = openInput.readLine();

					//正規表現で半角数字の1,2とqのみ受付
					if (AcceptUserInput.isEndCallWord(sexID)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					if (!MatcherPatternForUserInput.isConfirmInputOfSexID(sexID)) {
						System.out.println("正しく性別IDが入力されていません");
						inputSexID--;
					}
					if (sexID.equals("1")) {
						sexID = "男性";
					}
					if (sexID.equals("2")) {
						sexID = "女性";
					}
				}

				//郵便番号と番号から住所を取得
				for (int inputZipCode = 0; inputZipCode < 1; inputZipCode++) {
					System.out.println("郵便番号を入力してください");
					System.out.println("例:002-8026,0411622");
					System.out.println(":");
					zipCode = openInput.readLine();

					//正規表現で郵便番号とqのみ受け付け
					if (AcceptUserInput.isEndCallWord(zipCode)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					if (!MatcherPatternForUserInput.isConfirmInputOfZipCode(zipCode)) {
						--inputZipCode;
					}
				}

				//電話番号を取得
				for (int inputPhoneNumber = 0; inputPhoneNumber < 1; inputPhoneNumber++) {
					System.out.print("電話番号を入力してください。");
					System.out.println("例:06039957854,090-8543-5433 : ");
					phoneNumber = openInput.readLine();
					//正規表現でキャリア端末の電話番号(ハイフン有り無し)とqのみ受け付け
					if (AcceptUserInput.isEndCallWord(phoneNumber)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					if (!MatcherPatternForUserInput.isConfirmInputOfPhoneNumber(phoneNumber)) {
						inputPhoneNumber--;
					}

				}

				//メールアドレスを取得
				for (int inputEmailAddress = 0; inputEmailAddress < 1; inputEmailAddress++) {
					System.out.print("メールアドレスを入力してください。");
					System.out.println("例:hogehoge@gmail.com : ");
					emailAddress = openInput.readLine();
					//正規表現でメールアドレスとqのみ受け付け
					if (AcceptUserInput.isEndCallWord(emailAddress)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					if (!MatcherPatternForUserInput.isConfirmInputOfEmailAddress(emailAddress)) {
						inputEmailAddress--;
					}

				}

				//居住地域を取得
				for (int inputAreaID = 0; inputAreaID < 1; inputAreaID++) {
					System.out.println("居住地域(半角数字)を入力してください。:");
					System.out
							.println("1:北海道2:東北:3:関東4:中部5:近畿6:中国7:四国8:九州9:沖縄10:海外");
					System.out.println(":");
					areaID = openInput.readLine();
					//正規表現で1～10とqのみ受け付け

					if (AcceptUserInput.isEndCallWord(areaID)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					if (!MatcherPatternForUserInput.isConfirmInputOfAreaID(areaID)) {
						--inputAreaID;
					}

					switch (areaID) {
					case "1":
						areaID = "北海道";
						break;
					case "2":
						areaID = "東北";
						break;
					case "3":
						areaID = "関東";
						break;
					case "4":
						areaID = "中部";
						break;
					case "5":
						areaID = "近畿";
						break;
					case "6":
						areaID = "中国";
						break;
					case "7":
						areaID = "四国";
						break;
					case "8":
						areaID = "九州";
						break;
					case "9":
						areaID = "沖縄";
						break;
					case "10":
						areaID = "海外";
						break;
					default:
						System.out.println("居住地域が未入力です!!");
						inputAreaID--;
						break;
					}
				} // 居住地域を取得するfor文End

				//分類IDの取得
				for (int inputSortingID = 0; inputSortingID < 1; inputSortingID++) {
					System.out.println("分類ID(半角数字)を入力してください。:");
					System.out.println("1:家族2:友人:3:知り合い4:仕事5:お店6:その他");
					System.out.println(":");
					sortingID = openInput.readLine();
					//正規表現で1～6とqのみ受け付け
					if (AcceptUserInput.isEndCallWord(sortingID)) {
						setIsEndOfMenu4("q");
						break loop_startInputPersonalInfo;
					}
					if (!MatcherPatternForUserInput.isConfirmInputOfSortingID(sortingID)) {
						--inputSortingID;
					}
					switch (sortingID) {
					case "1":
						sortingID = "家族";
						break;
					case "2":
						sortingID = "友人";
						break;
					case "3":
						sortingID = "知り合い";
						break;
					case "4":
						sortingID = "仕事";
						break;
					case "5":
						sortingID = "お店";
						break;
					case "6":
						sortingID = "その他";
						break;
					default:
						System.out.println("分類IDが正しくありません!!");
						inputSortingID--;
						break;
					}
				} // 分類IDの取得するfor文End

				//取得した情報を","区切りの文字列にして参照
				this.personalInfo = personName + "," + readName + "," + sexID + ","
						+ zipCode + "," + address + "," + phoneNumber + ","
						+ emailAddress + "," + areaID + "," + sortingID;

			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	public String getPersonalInfo() {
		return this.personalInfo;
	}

	//"01HOKKAI.CSV"から郵便番号を元に住所情報を取得する補助メソッド
	public String getAddress(String zipCode) {

		String address = "該当する住所がありません";
		String[] str = null;
		try (BufferedReader br = new BufferedReader(new FileReader("01HOKKAI.CSV"))) {

			for (int i = 0; (address = br.readLine()) != null; i++) {
				str = address.split(",");
				String no = str[2].replace("\"", "");
				if (zipCode.equals(no)) {
					String dou = str[6].replace("\"", "");
					String shityou = str[7].replace("\"", "");
					String chiku = str[8].replace("\"", "");
					address = zipCode + " " + dou + shityou + chiku;
					break;
				}
			}
			// yuubin = "該当する住所はありません。";
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		return address;

	}
}
