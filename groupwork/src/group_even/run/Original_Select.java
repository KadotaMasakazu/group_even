package group_even;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Original_Select {
	private String select = "";// 手紙の種類
	private String sentence = "";// メッセージの入力
	String[][] kind = {
			{
					"家族",
					"あけましておめでとうございます！\n" + "今年はぜひ家族そろってお伺いしたいと思っております\n"
							+ "お体を大切にしてくださいね" },
			{ "友人", "あけましておめでとう！\n" + "今年もよろしくね！\n" + "早く飲みに行こう！" },
			{
					"仕事",
					"恭賀新年\n旧年中は格別のご厚情を賜り誠にありがとうございます\n"
							+ "今年も前年と変わらぬご指導をいただけますよう\n" + "よろしくお願いいたします" }

	}; // 届け先の関係とメッセージ
	String distination = "";

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getSentence() {
		return sentence;
	}

	public void select() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
				"sentence.txt", true));
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in))) {

			System.out.println("どの手紙を送りますか。\n１：年賀状\n２：暑中お見舞い\n３：寒中お見舞い");
			select = br.readLine();

			switch (select) {
			case "1":
			case "１":
				for (;;) {
					System.out.print("届け先との関係を選んでください：");
					for (int i = 0; i < kind.length; i++) {
						System.out.print((i + 1) + ":" + kind[i][0] + " ");
					}
					distination = br.readLine();

					if (distination.equals("1")) {
						sentence = kind[0][1];
					} else if (distination.equals("2")) {
						sentence = kind[1][1];
					} else if (distination.equals("3")) {
						sentence = kind[2][1];
					} else {
						System.out.println("もう一度入力してください。");
					}
				}

			case "2":
			case "２":
				sentence="暑中お見舞い申し上げます。";
			case "3":
			case "３":
				sentence ="寒中お見舞い申し上げます。";

			default:
				break;

			}
		} catch (IOException e) {
			System.out.println("IOException Error");
		}

	}
}
