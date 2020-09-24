package group_even;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class GetAddressKeyWord_ArrayForPlaceNameGame {

	public void getAddressFromUsetInputtedKeyword() {


		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			GetAddressKeyWord.getlist();
			int CountProblem=0;
			while(true){
				System.out.println("次の地名のよみがなを半角カタカナで入力してください。("+AcceptUserInput.ENDCALLOFLOOP+ "で終了)");
				System.out.print(GetAddressKeyWord.shuffleList() + ":");
				String place_name = br.readLine();
				if(AcceptUserInput.isEndCallWord(place_name)){
					break;
				}
				//正規表現で判断して再度入力を促す
				if(!MatcherPatternForUserInput.isConfirmInputOfHalfwidthKatakana(place_name)){
					continue;
				}
				GetAddressKeyWord.getAddress(place_name);
				CountProblem++;
			}
			System.out.println(GetAddressKeyWord.correctAns(GetAddressKeyWord.getSeikai(), CountProblem));
		}catch(IOException e){

		}finally{
			System.out.println("プログラムを終了します。");
		}

	}

}

