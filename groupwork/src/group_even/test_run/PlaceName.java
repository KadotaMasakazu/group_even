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
			System.out.println("ファイルエラー");
		}

	}
	public static void getAddress(String place_name){ //20200924～ 半角数字→全角数字変換するアルゴリズム
		String address= "該当する地名はありませんでした。";
		int cnt =0;
		for(PlaceName p:addList){
			PlaceName pl=p;
			String serch = pl.dou+pl.shikuchoson+pl.chiiki;
			if(serch.contains(place_name)){
				address=pl.y_no + " " + pl.dou+pl.shikuchoson+pl.chiiki;
				System.out.println(address);
				cnt++;
			}
			//メモ ^.* place_name .*$
		}
		if(cnt != 0){
			System.out.printf("全部で%d件です",cnt);
		}else{
			System.out.printf("\n%s",address);
		}

	}
}

