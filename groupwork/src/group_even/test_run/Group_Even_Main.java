package group_even;



public class Group_Even_Main {

	public static void main(String[] args) {

		//住所関係アプリの入力受付開始
		try {
			AcceptUserInput startApp = new AcceptUserInput();
		startApp.inputReception();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("終了します。");
		}

	}
}
