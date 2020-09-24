package group_even;

import java.io.BufferedReader;
/*
郵便番号から番号に合致する住所を取得する

getAddressとconvertInputtedZipCodeメソッドはstatic->Original
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowAddressFromZipCode {
	String zipCode = "";

	public void getAddressFromZipCode() {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))){
			for (;;) {
				System.out.println("郵便番号を入力してください。("+AcceptUserInput.ENDCALLOFLOOP+ "で終了):");
				zipCode = br.readLine();
				if (AcceptUserInput.isEndCallWord(zipCode)) {
					break;
				}
				// 正規表現で判断して再度入力を促す
				if (!MatcherPatternForUserInput
						.isConfirmInputOfZipCode(zipCode)) {
					continue;
				}
				if(8==zipCode.length()){
					zipCode=zipCode.replace("-","");
					System.out.print("〒"+zipCode.substring(0,3)+"-"+zipCode.substring(3,7)+getAddress(zipCode));
					System.out.println();
					}else{
					System.out.print("〒"+zipCode.substring(0,3)+"-"+zipCode.substring(3,7)+getAddress(zipCode));
					System.out.println();
					}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getAddress(String zipCode) {
		String address = "該当する住所がありません";
		BufferedReader br = null;
		String[] str;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					"01HOKKAI.CSV")));
			String s = "";
			zipCode = ShowAddressFromZipCode.convertInputtedZipCode(zipCode);
			while ((s = br.readLine()) != null) {
				str = s.split(",");
				String no = str[2].replace("\"", "");
				if (zipCode.equals(no)) {
					String dou = str[6].replace("\"", "");
					String shityou = str[7].replace("\"", "");
					String chiku = str[8].replace("\"", "");
					address = dou + shityou + chiku;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return address;
	}


	public static String  convertInputtedZipCode(String zipCode){
		//ハイフン含みの郵便番号をハイフン抜きにする。
		if(8==zipCode.length()){
			zipCode=zipCode.replace("-","");
			}
		return zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
