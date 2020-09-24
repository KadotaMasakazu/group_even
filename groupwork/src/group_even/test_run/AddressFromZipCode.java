package group_even;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddressFromZipCode {
	String zipCode = "";

	public void getAddressFromZipCode() {

		try {
			System.out.print("〒" + zipCode.substring(0, 3) + "-" + zipCode.substring(3, 7)
					+ getAddress(zipCode));
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String getAddress(String yu) {
		String address = "該当する住所がありません";
		BufferedReader br = null;
		String[] str;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("01HOKKAI.CSV")));
			String s = "";
			while ((s = br.readLine()) != null) {
				str = s.split(",");
				String no = str[2].replace("\"", "");
				if (yu.equals(no)) {
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
