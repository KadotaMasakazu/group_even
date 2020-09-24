package group_even;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Original_Input2 {

	private String zipcode2;
	private String address2;
	private String name2;

	public void input2(){   //宛名の作成

		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("宛名を入力してください");

			System.out.print("郵便番号を入力してください：");
			zipcode2=br.readLine();

			System.out.print("住所を入力してください：");
			//System.out.print(①で呼び出す);
			address2=br.readLine();
			//address=①で呼び出した+address;

			System.out.print("名前を入力してください：");
			name2=br.readLine();


		}catch(IOException e){
			System.out.print("IOEエラー");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String getZipcode() {
		return zipcode2;
	}

	public void setZipcode(String zipcode) {
		this.zipcode2 = zipcode2;
	}

	public String getAddress() {
		return address2;
	}

	public void setAddress(String address) {
		this.address2 = address2;
	}

	public String getName() {
		return name2;
	}

	public void setName(String name) {
		this.name2 = name2;
	}



}
