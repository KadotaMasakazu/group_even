package group_even_test.group_even.AcceptUserInput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OutputAddressFromZipCode {
	String zipCode = "";

	public void outputAddress() {
		System.out.println(getAddress(getZipCode()));

	}

	public String getAddress(String zipCode) {
		BufferedReader br = null;
		String yuubin = "該当する住所がありません";
		String[] str = null;
		try {
						System.out.println("受け取った情報:"+getZipCode());
			br = new BufferedReader(new FileReader("01HOKKAI.CSV"));
			for (int i = 0; (yuubin = br.readLine()) != null; i++) {
				str = yuubin.split(",");
				String no = str[2].replace("\"", "");//CSVファイルの数値は""があるためreplaceで取り除く。
				//				""を空白として置換している
				//				System.out.println(str[2]);
				if (zipCode.equals(no)) {
					String dou = str[6].replace("\"", "");
					String shityou = str[7].replace("\"", "");
					String chiku = str[8].replace("\"", "");
					yuubin = dou + shityou + chiku;
					break;
				}
			}
			//			yuubin = "該当する住所はありません。";
		} catch (NumberFormatException e1) {

		} catch (FileNotFoundException e2) {
		} catch (IOException e3) {
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return yuubin;

	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}