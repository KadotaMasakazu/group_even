package group_even;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class GetAddressKeyWord {
	/*フィールドの設定 ArrayListはstatic参照*/
	private static ArrayList<GetAddressKeyWord> addList;
	private String chimei;
	private String kana;
	private static String ques;
	private static String ans;
	private static int seikai;

	public String getChimei() {
		return chimei;
	}
	public void setChimei(String chimei) {
		this.chimei = chimei;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public static String getQues() {
		return ques;
	}
	public static void setQues(String ques) {
		GetAddressKeyWord.ques = ques;
	}
	public static String getAns() {
		return ans;
	}
	public static void setAns(String ans) {
		GetAddressKeyWord.ans = ans;
	}
	public static int getSeikai() {
		return seikai;
	}
	public static void setSeikai(int seikai) {
		GetAddressKeyWord.seikai = seikai;
	}
	public GetAddressKeyWord(){
		//コンストラクターの初期化
		this("名無し", "よみなし");
	}
	public GetAddressKeyWord(String chimei,String kana){
		this.chimei=chimei;
		this.kana=kana;
	}
	public static void getlist(){
		addList=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("01HOKKAI.CSV"),"MS932"))){
			String one_line="";
			while((one_line=br.readLine()) !=null){
				String str[]=one_line.split(",");
				String kana=str[5].replace("\"","");
				String chimei=str[8].replace("\"","");
				if(!(chimei.equals("以下に掲載がない場合"))){
					GetAddressKeyWord pl=new GetAddressKeyWord(chimei, kana);
					addList.add(pl);
				}
			}
		}catch (IOException e) {
			System.out.println("ファイルエラー");
			e.printStackTrace();
		}catch (NullPointerException e){
			System.out.println("値がnullです。");
			e.printStackTrace();
		}
	}

	public static String shuffleList(){
//		重複問題なし最大8236問 "以下に掲載がない場合"除く
		int ct = 0;
		Collections.shuffle(addList);
		for (int i = 0; i < addList.size(); i++) {
			ques = addList.get(i).chimei;
			ans = addList.get(i).kana;
		}

		return ques;

//		重複問題あり8236以上の問題出題
//		int runsuu = (int)(Math.random()*addList.size())+1;
//		ques = addList.get(runsuu).chimei;
//		while(ques.equals("以下に掲載がない場合")){
//			runsuu = (int)(Math.random()*addList.size())+1;
//			ques = addList.get(runsuu).chimei;
//		}
//		ans = addList.get(runsuu).kana;
	}

	public static void getAddress(String place_name){
		boolean h = false;
		for(Object p :addList){
			if(ans.equals(place_name)){
				h =true;
			}
		}
		correctWrong(h);
	}

	public static void correctWrong(boolean h){
		if(h){
			System.out.println("正解です\n");
			seikai++;
		}else{
			System.out.println("不正解です。");
			System.out.println("問題は : " + getQues() + " です。 答えは : " + getAns() + " です。\n");
		}
	}

	public static String correctAns(int seikai,int total){
		String result = "一問も答えておりませんので正解率はだせません";
		double rate = 0.0;
		if(total != 0){
			//正解率の計算。
			rate = (double)getSeikai() / total * 100;
			result = total + "問中" + getSeikai() + "問正解" + (int)rate + "%です。";
		}
		return result;
	}
}

