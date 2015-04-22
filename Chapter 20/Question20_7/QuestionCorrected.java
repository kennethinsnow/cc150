package Question20_7;

import java.util.Arrays;
import java.util.HashMap;

public class QuestionCorrected {
	HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	public void getLongestWord(String arr[]) {
		for (String str : arr) {
			map.put(str, true);
		}
		Arrays.sort(arr, new LengthComparator()); // Sort by length

		for (int i = 0; i < arr.length; i++) {
			String str = arr[i];
			for (int j = 1; j < str.length(); j++){
				if (map.containsKey(str.substring(0, j)) && isCombo(str.substring(j))){
					System.out.println("Longest word: " + str);
					return;
				}
					
			}
		}
		System.out.println("No such word");
	}
	
	private boolean isCombo(String st){
		if (st.length() == 0) return true;
		for (int i = 1; i <= st.length(); i++){
			if (map.containsKey(st.substring(0, i)) && isCombo(st.substring(i)))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String arr[] = {"test", "tester", "testertest", "testing", 
				"apple", "seattle", "banana",  "batting", "ngcat", 
				"batti","bat", "testingtester", "testbattingcat"};
		new QuestionCorrected().getLongestWord(arr);
	}
}
