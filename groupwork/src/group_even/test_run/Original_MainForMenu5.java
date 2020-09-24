package group_even;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Original_MainForMenu5 {

	public void startAppOfOriginal() {
		Original_Select os = new Original_Select(); //自分の情報を登録
		Original_Input1 oi1 = new Original_Input1(); //何を作成するか、どの文章にするか
		Original_Input2 oi2 = new Original_Input2(); //宛名の作成
		HashMap<String, String> hm = new HashMap<>();

		try {
			System.out.println("簡単に「年賀状」or「暑中お見舞い」or「寒中お見舞い」が作れます。");

			oi1.input1();//自分の情報を登録

			os.select();//作成目的により文章が変わる
			hm.put("文章", os.getSentence());

			oi2.input2();//宛名の作成
			hm.put("郵便番号", oi2.getZipcode());
			hm.put("住所", oi2.getAddress());
			hm.put("名前", oi2.getName());

			try (BufferedWriter bw = new BufferedWriter(new FileWriter("Original.txt"));
					BufferedReader br = new BufferedReader(new FileReader("sentence.txt"))) {
				bw.write(hm.get("郵便番号") + System.lineSeparator());
				bw.write(hm.get("住所") + System.lineSeparator());
				bw.write(hm.get("名前") + System.lineSeparator() + System.lineSeparator());
				bw.write(hm.get("文章") + System.lineSeparator() + System.lineSeparator());

				String s;
				while ((s = br.readLine()) != null) {
					String[] ary = s.split(",");
					for (String output : ary) {
						bw.write(output + System.lineSeparator());
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルに誤り");
		} catch (IOException e) {
			System.out.print("IOE");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
