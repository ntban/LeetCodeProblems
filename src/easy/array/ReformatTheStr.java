package easy.array;

import java.util.ArrayList;

public class ReformatTheStr {

	public String reformat(String s) {
		ArrayList<Character> letters = new ArrayList<>();
		ArrayList<Character> digits = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z') {
				letters.add(c);
			} else if (c >= '0' && c <= '9') {
				digits.add(c);
			}

		}
		if (letters.size() == digits.size() || letters.size() == digits.size() + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < digits.size(); i++) {
				sb.append(letters.get(i));
				sb.append(digits.get(i));
			}
			if(letters.size() == digits.size() + 1) {
			sb.append(letters.get(letters.size()-1));
			}
			return sb.toString();
		} else if (letters.size() + 1 == digits.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < letters.size(); i++) {
				sb.append(digits.get(i));
				sb.append(letters.get(i));
			}
			sb.append(digits.get(digits.size()-1));
			return sb.toString();
		}
		return "";
	}

	public static void main(String[] args) {
		String s = "ab123";
		System.out.println(new ReformatTheStr().reformat(s));
	}
}
