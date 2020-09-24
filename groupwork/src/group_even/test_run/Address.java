package group_even;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class Address {

	public static void main(String[] args) {
		BufferedReader br=null;
		String yu="";
		try{
			br=new BufferedReader(new InputStreamReader(System.in));
			for(;;){
				System.out.println("郵便番号を入力してください：");
				yu=br.readLine();
				System.out.print("〒"+yu.substring(0,3)+"-"+yu.substring(3,7)+getAddress(yu));
				System.out.println();
			}
		}catch(IOException e){
			System.out.println("IO");
		}finally{
			try{
				if(br !=null){
					br.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	public static String getAddress(String yu){
		String address ="該当する住所がありません";
		BufferedReader br=null;
		String []str;
		try{
			br=new BufferedReader(new InputStreamReader(new FileInputStream("01HOKKAI.CSV")));
			String s="";
			while((s=br.readLine())!=null){
				str=s.split(",");
				String no=str[2].replace("\"","");
				if(yu.equals(no)){
					String dou=str[6].replace("\"", "");
					String shityou=str[7].replace("\"", "");
					String chiku=str[8].replace("\"", "");
					address=dou+shityou+chiku;
				}
			}
		}catch(IOException e){
			System.out.println("IOE");
		}finally{
			try{
				if(br !=null){
					br.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		return address;
	}

}
