package minimum.array;

import java.util.ArrayList;
import java.util.Collections;

class Word implements Comparable<Word> {
	public String text;
	public int index;
	public String startWord;
	public String normalWord;

	public Word(String txt, int index) {
		super();
		this.text = txt;
		this.index = index;

	}

	public void lowerUpper() {
		String postFix = text.substring(1, text.length());
		char lowerCase = ' ', upperCase = ' ';
		char c = text.charAt(0);
		if (c >= 'a' && c <= 'z') {
			lowerCase = c;
			upperCase = (char) ('A' + (c - 'a'));
		} else {
			upperCase = c;
			lowerCase = (char) ('a' + (c - 'A'));
		}
		startWord = upperCase + postFix;
		normalWord = lowerCase + postFix;
	}

	@Override
	public int compareTo(Word o) {
		int l1 = text.length();
		int l2 = o.text.length();
		if (l1 == l2) {
			if (index > o.index)
				return 1;
			return -1;
		}
		if (l1 < l2)
			return -1;
		return 1;
	}

}

public class ArrangeWord {
	public String arrangeWords(String text) {
		String[] arr = text.split(" ");
		ArrayList<Word> wordList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			wordList.add(new Word(arr[i], i));
		}
		Collections.sort(wordList);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i< wordList.size(); i++) {
			Word word = wordList.get(i);
			if(i == 0 || word.index == 0) {
				word.lowerUpper();
				if(i == 0) sb.append(word.startWord);
				else sb.append(word.normalWord);
				sb.append(" ");
				continue;
			}
			sb.append(word.text).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
