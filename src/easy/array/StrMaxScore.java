package easy.array;

public class StrMaxScore {
	public int maxScore(String s) {
		int zero[] = new int[s.length() + 1];
		int one[] = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				zero[i + 1] = zero[i] + 1;
				one[i + 1] = one[i];
			} else {
				one[i + 1] = one[i] + 1;
				zero[i + 1] = zero[i];
			}
		}
		int max = 0;
		for (int i = 1; i <= s.length() - 1; i++) {
			int score = zero[i] + (one[s.length()] - one[i ]);
//			System.out.printf("%d %d\n", i, score);
			if (score > max)
				max = score;
		}
		return max;
	}

	public static void main(String[] args) {
//		String s = "00";
//		String s = "1111";
//		String s = "011101";
		String s = "00111";
		System.out.println(new StrMaxScore().maxScore(s));
	}
}
