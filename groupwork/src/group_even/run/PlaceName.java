package group_even;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PlaceName {
	private static ArrayList<PlaceName> addList;
	private String y_no;
	private String dou;
	private String shikuchoson;
	private String chiiki;

	public PlaceName(){
		this("0000000", "道","市町村", "地域");
	}
	public PlaceName(String y_no,String dou,String shikuchoson,String chiiki){
		this.y_no=y_no;
		this.dou=dou;
		this.shikuchoson=shikuchoson;
		this.chiiki=chiiki;
	}

	public static void getlist(){
		addList=new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("01HOKKAI.CSV"),"MS932"))){
			String one_line="";
			while((one_line=br.readLine()) !=null){
				String str[]=one_line.split(",");
				String y_no=str[2].replace("\"","");
				String dou=str[6].replace("\"","");
				String shikuchoson=str[7].replace("\"","");
				String chiiki=str[8].replace("\"","");
				PlaceName pl=new PlaceName(y_no, dou, shikuchoson, chiiki);
				addList.add(pl);
			}
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("ファイルエラー");
		}

	}

	public static String half_to_FullConvert(String place_name){//半角数字のみ→全角数字に変換 09/24
		StringBuffer sb = new StringBuffer(place_name);
		try{
			if(place_name == null){
	            throw new IllegalArgumentException();
	        }
	        for (int i = 0; i < place_name.length(); i++) {
	            char ch = place_name.charAt(i);
	          //１０進数で'0' 48 '9'57  １０進数で '０' 65296←Unicode
	            if ('0' <= ch && ch <= '9') {
	                sb.setCharAt(i, (char) (ch - '0' + '０'));
	            }
	        }
		}catch (StringIndexOutOfBoundsException e){
//			e.printStackTrace();
			System.out.println("for文でエラー。(配列)");
		}catch(IllegalArgumentException e){
//			e.printStackTrace();
			System.out.println("不正な引数または不適切な引数をメソッドに渡しております。");
		}
		return sb.toString();
	}

	public static void getAddress(String place_name){
		String address= "該当する地名はありませんでした。";
		int cnt =0;
		place_name = half_to_FullConvert(place_name);
		for(PlaceName p:addList){
			PlaceName pl=p;
			String serch = pl.dou+pl.shikuchoson+pl.chiiki;
			if(serch.contains(place_name)){
				address=pl.y_no + " " + pl.dou+pl.shikuchoson+pl.chiiki;
				System.out.println(address);
				cnt++;
			}
		}
		if(cnt != 0){
			System.out.printf("全部で%d件です",cnt);
		}else{
			System.out.printf("\n%s",address);
		}
	}
}
