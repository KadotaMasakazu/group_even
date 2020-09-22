package group_even.getaddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GetAddressKeyWord_Array {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			GetAddressKeyWord.getlist();
			int total=0;
			while(true){
				System.out.println("次の地名のよみがなを半角カタカナで入力してください。(qで終了) ");
				System.out.print(GetAddressKeyWord.shuffleList() + ":");
				String place_name = br.readLine();
				//正規表現で判断する処理の追加2020/0921
				System.out.println(Macher_Pattern.meth2(place_name));
				if(place_name.equals("q") || place_name.equals("ｑ") ){
					break;
				}else if(place_name.equals("")){
					System.out.println("指定の文字を入力してください。");
					continue;
				}
				GetAddressKeyWord.getAddress(place_name);
				total++;
//				System.out.println("正解は" + GetAddressKeyWord.seikai);

			}
			System.out.println(GetAddressKeyWord.correctAns(GetAddressKeyWord.seikai, total));
		}catch(IOException e){

		}finally{
			System.out.println("プログラムを終了します。");
		}

	}

}

