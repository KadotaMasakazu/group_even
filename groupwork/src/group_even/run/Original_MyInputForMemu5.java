package group_even;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Original_MyInputForMemu5 {
	//public static void main(String[] args) {
	private String selectNum;
	private String myZipcode;
	private String myAddress;
	private String myName;
		public void input1(){

			BufferedWriter bw=null;
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			loop1:for(;;){  //登録済みor登録終了時ループ脱出
				System.out.println("あなたの情報は登録済みですか？");
				System.out.print("未登録の場合は1、登録済みの方は2を入力してください。");
				selectNum=br.readLine();
				//1と2以外は再度入力を促す
				if(!MatcherPatternForUserInput.isConfirmInputOfOriginal1OR2(selectNum)){
					System.out.println("1か2を入力してください");
					continue;
				}
				if(selectNum.equals("2")){
					break loop1;
				}else if(selectNum.equals("1")){
					bw = new BufferedWriter(new FileWriter("myInfomation.txt"));
					System.out.print("あなたの情報を登録してください");

					System.out.println("宛名を入力してください");

				 do{ //正しい郵便番号を入力するまでループ
					System.out.print("\n郵便番号を入力してください：");
					myZipcode=br.readLine();
//					郵便番号の形式に合致してなければ再度入力を促す
					if(!MatcherPatternForUserInput.isConfirmInputOfZipCode(myZipcode)){
						continue;
					}

					System.out.print("住所を入力してください：");
					System.out.print(ShowAddressFromZipCode.getAddress(myZipcode));

					}while(ShowAddressFromZipCode.getAddress(myZipcode).equals("該当する住所がありません"));
//住所追記分
				 	myAddress=br.readLine();
				 	myAddress=ShowAddressFromZipCode.getAddress(myZipcode)+myAddress;

					//名前は正規表現で判別しないまま出力
					System.out.print("名前を入力してください：");
					myName=br.readLine()+"より";


					bw.write("〒"+myZipcode+System.lineSeparator());
					bw.write(myAddress+System.lineSeparator());
					bw.write(myName+System.lineSeparator());
					break loop1;
				}else{
					continue;  //1か2を選ぶまで続ける
				}
			}
		} catch (FileNotFoundException e){
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(bw !=null){
					bw.close();
				}
				}catch(IOException e){
				}
			}
	}
}
