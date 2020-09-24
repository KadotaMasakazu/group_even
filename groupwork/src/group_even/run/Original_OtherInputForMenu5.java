package group_even;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Original_OtherInputForMenu5 {

	private String otherZipcode;
	private String otherAddress;
	private String otherName;

	public void input2(){   //宛名の作成

		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("次に宛名を入力してください");

			do{
				System.out.print("\n郵便番号を入力してください：");
				otherZipcode=br.readLine();
//				郵便番号の形式に合致してなければ再度入力を促す
				if(!MatcherPatternForUserInput.isConfirmInputOfZipCode(otherZipcode)){
					continue;
				}

				System.out.print("住所を入力してください：");
				System.out.print(ShowAddressFromZipCode.getAddress(otherZipcode));

				}while(ShowAddressFromZipCode.getAddress(otherZipcode).equals("該当する住所がありません"));
			otherAddress=br.readLine();
			otherAddress=ShowAddressFromZipCode.getAddress(otherZipcode)+otherAddress;

			System.out.print("名前を入力してください：");
			otherName=br.readLine();

		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String getOtherZipcode() {
		return otherZipcode;
	}

	public void setOtherZipcode(String otherZipcode) {
		this.otherZipcode = otherZipcode;
	}

	public String getOtherAddress() {
		return otherAddress;
	}

	public void setOtherAddress(String otherAddress) {
		this.otherAddress = otherAddress;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}






}
