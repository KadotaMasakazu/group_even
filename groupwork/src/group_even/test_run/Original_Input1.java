package group_even;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Original_Input1 {
	//public static void main(String[] args) {
	private String selectNum;
	private String zipcode;
	private String address;
	private String name;
		public void input1(){
		File f=new File("sentence.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sentence.txt"))){
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			loop1:for(;;){
				System.out.println("あなたの情報は登録済みですか？");
				for(;;){
				System.out.println("未登録の場合は1、登録済みの方は2を入力してください。");
				selectNum=br.readLine();
				if(selectNum.equals("2")||selectNum.equals("２")){
					break loop1;
				}else if(selectNum.equals("1")||selectNum.equals("１")){
					System.out.print("あなたの情報を登録してください");
					
					System.out.println("宛名を入力してください");

					System.out.print("郵便番号を入力してください：");
					zipcode=br.readLine();

					System.out.print("住所を入力してください：");
					//System.out.print(①で呼び出す);
					address=br.readLine();
					//address=①で呼び出した+address;

					System.out.print("名前を入力してください：");
					name=br.readLine();
					
					bw.write(zipcode+System.lineSeparator());
					bw.write(address+System.lineSeparator());
					bw.write(name+System.lineSeparator());
					break loop1;
				}else{
					continue;
				}
				}
			}

		} catch (FileNotFoundException e){
		}catch (IOException e) {
			System.out.println("IOE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
