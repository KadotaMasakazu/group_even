package group_even;
import java.util.regex.Pattern;
public class Macher_Pattern {

	private static String input;
	private static String ans;
	public void meth1(String input){

		String regex = "^.*" + "[" + input +"]" + ".*";

		Pattern p = Pattern.compile(regex);

	}
	public static boolean meth2(String input){
		boolean result = false;
		Pattern p = Pattern.compile("[\uFF65-\uFF9F]+$");
		if(input!=null){
			result = p.matcher(input).matches();
		}
		return result;
	}
}
