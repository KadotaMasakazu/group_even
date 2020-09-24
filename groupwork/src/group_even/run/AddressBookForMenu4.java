package group_even;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBookForMenu4 {
	private String personalInfo = "";

	public void outputPersonalInfoTo01HOKKAI() {

		String s = personalInfo;

		String[] str;
		try (BufferedWriter br = new BufferedWriter(new FileWriter(
				"AddressBook.csv"))) {
			while (s != null) {
				str = s.split(",");
				if (8 == str[3].length()) {
					str[3] = str[3].replace("-", "");
				}
				String outputPersonalInfo = "";
				for (int i = 1; i < str.length; i++) {
					if (i == str.length - 1) {
						outputPersonalInfo += str[i];
					} else {
						outputPersonalInfo += str[i] + ",";

					}
					br.write(outputPersonalInfo);

					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルなし");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}
}