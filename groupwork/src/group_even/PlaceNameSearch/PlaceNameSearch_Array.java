package even;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PlaceNameSearch_Array {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			PlaceName.getlist();
			PlaceName pln = new PlaceName();

			while(true){
				System.out.print("地名の一部を入力してください。(qで終了) :");
				String place_name = br.readLine();
				if(place_name.equals("q") || place_name.equals("ｑ") ){
					break;
				}else if(place_name.equals("")){
					System.out.println("何か文字を入力してください。");
					continue;
				}
				PlaceName.getAddress(place_name);
				System.out.println("\n");
			}
		}catch(IOException e){

		}finally{
			System.out.println("終了します。");
		}

	}

}

