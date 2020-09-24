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
		Original_SelectForMemu5 os=new Original_SelectForMemu5();        //自分の情報を登録
		Original_MyInputForMemu5 oi1=new Original_MyInputForMemu5();       //何を作成するか、どの文章にするか
		Original_OtherInputForMenu5  oi2=new Original_OtherInputForMenu5();      //宛名の作成
		HashMap<String,String>hm=new HashMap<>();

		System.out.println("簡単に「年賀状」or「暑中お見舞い」or「寒中お見舞い」が作れます。\n");

		oi1.input1();//自分の情報を登録

		os.select();//作成目的により文章が変わる
		hm.put("文章",os.getSentence());

		oi2.input2();//宛名の作成
		hm.put("郵便番号", oi2.getOtherZipcode());
		hm.put("住所", oi2.getOtherAddress());
		hm.put("名前", oi2.getOtherName()+"様");


		try(BufferedWriter bw=new BufferedWriter(new FileWriter("Original.txt"));
				BufferedReader br=new BufferedReader(new FileReader("myInfomation.txt"))){

			//宛名の出力
			bw.write(hm.get("郵便番号")+System.lineSeparator());
			bw.write(hm.get("住所")+System.lineSeparator());
			bw.write(hm.get("名前")+System.lineSeparator()+System.lineSeparator());

			//選んだ文章の出力
			bw.write(hm.get("文章")+System.lineSeparator()+System.lineSeparator());

			//保存している自分の情報の出力
			String s;
			while((s=br.readLine())!=null){
				String[] ary=s.split(",");
				for(String output:ary){
					bw.write(output+System.lineSeparator());
			}
			}
			System.out.println("終了しました。ファイルを確認してください。");
		}catch(FileNotFoundException e){
			System.out.println("あなたの情報が登録されていないようです\n"
					+ "初めからやり直してください");
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
