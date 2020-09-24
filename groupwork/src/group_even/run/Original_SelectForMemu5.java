package group_even;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Original_SelectForMemu5 {
	private String select = "";// 手紙の種類
	private String sentence = "";// メッセージの入力
	private String distination = ""; //送り先
	String[][] kind = {
			{"家族",
			"あけましておめでとうございます！\n" + "今年はぜひ家族そろってお伺いしたいと思っております\n"
			+ "お体を大切にしてくださいね" },
			{ "友人", "あけましておめでとう！\n" + "今年もよろしくね！\n"
				+ "早く飲みに行こう！" },
			{"仕事",
			"恭賀新年\n旧年中は格別のご厚情を賜り誠にありがとうございます\n"
			+ "今年も前年と変わらぬご指導をいただけますよう\n" + "よろしくお願いいたします" }

	}; // 届け先の関係とメッセージ



	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getSentence() {
		return sentence;
	}

	public void select() {
		try  {
			BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));

			System.out.println("\nどの手紙を送りますか。\n１：年賀状\n２：暑中お見舞い\n３：寒中お見舞い");
			loop_A: for(;;){ //手紙ループ
				select = br.readLine();
				if(!MatcherPatternForUserInput.isConfirmInputOfOriginal_Select(select)){
					System.out.println("1から3の数字を入力してください。：");
					System.out.println();
					continue;
				}
			if(select.equals("1")|| select.equals("2")|| select.equals("3")){

			switch (select) {
			case "1":

					System.out.print("届け先との関係を選んでください：");
					for (int i = 0; i < kind.length; i++) {
						System.out.print((i + 1) + ":" + kind[i][0] + " ");
					}
					for(;;){ //届け先の関係ループ
					distination = br.readLine();
					if(!MatcherPatternForUserInput.isConfirmInputOfOriginal_Select(distination)){
						System.out.println("1から3の数字を入力してください。：");
						System.out.println();
						continue;
					}

					if((distination.equals("1")||distination.equals("2")||distination.equals("3"))){

					if (distination.equals("1")) {
						sentence = kind[0][1];
						break loop_A;
					} else if (distination.equals("2")) {
						sentence = kind[1][1];
						break loop_A;
					} else if (distination.equals("3")) {
						sentence = kind[2][1];
						break loop_A;
					} else {
						System.out.println("もう一度入力してください。");
					}

					}else{ //届け先ループ
						System.out.println("1から3の数字を入力してください。：");
						System.out.println();
					}

				}


			case "2":
				sentence="暑中お見舞い申し上げます。"
						+ "\n昨年にもまして暑さが厳しく感じられます。"
						+ "\nお体を大切にお過ごしください。";
				break loop_A;
			case "3":
				sentence ="寒中お見舞い申し上げます。"
						+ "\nご服喪中と伺い年始のご挨拶はさし控えさせていただきました。"
						+ "\n春の訪れが待ち遠しいですが、いましばらくは寒さも続くかと思いますので"
						+ "\nくれぐれもお体を大切にお過ごしください";
				break loop_A;

			default:
				break;
			}
			}else{ //手紙ループ
				System.out.println("1から3の数字を入力してください。：");
				System.out.println();
			}
		}

		} catch (IOException e) {
			System.out.println("IOException Error");
		}

	}
}
