package minimum.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckCanBreak {
	public boolean checkIfCanBreak(String s1, String s2) {
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) {
			list1.add(s1.charAt(i));
			list2.add(s2.charAt(i));
		}
		Collections.sort(list1);
		Collections.sort(list2);
		int compare = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) == list2.get(i)) {
				continue;
			}
			if (compare == 1 && list1.get(i) < list2.get(i)) {
				return false;
			}
			if (compare == -1 && list1.get(i) > list2.get(i)) {
				return false;
			}

			if (compare == 0 && list1.get(i) > list2.get(i)) {
				compare = 1;
				continue;
			}
			if (compare == 0 && list1.get(i) < list2.get(i)) {
				compare = -1;
				continue;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "leetcodee";
		String s2 = "interview";
		System.out.println(new CheckCanBreak().checkIfCanBreak(s1, s2));
		
	}
}
