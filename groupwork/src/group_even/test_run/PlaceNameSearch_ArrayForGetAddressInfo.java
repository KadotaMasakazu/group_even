package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlaceNameSearch_ArrayForGetAddressInfo {

	private String place_name = "";

	public void getAddressFromUserInputAddressPartialInfo() {

		// TODO 自動生成されたメソッド・スタブ
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in))) {
			PlaceName.getlist();

			while (true) {
				System.out.print("地名の一部を入力してください。(qで終了) :");
				place_name = br.readLine();
				if (AcceptUserInput.isEndCallWord(place_name)) {
					break;
				}
				// 正規表現で判断して再度入力を促す
				if (!MatcherPatternForUserInput
						.isConfirmInputOfAddressPartialInfo(place_name)) {
					continue;
				}
				PlaceName.getAddress(place_name);
				System.out.println("\n");
			}
		} catch (IOException e) {

		} finally {
			System.out.println("終了します。");
		}

	}

	public String getPlace_name() {
		return place_name;
	}

	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
}
