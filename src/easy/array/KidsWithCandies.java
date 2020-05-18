package easy.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> results = new ArrayList<>();
		int max = -1;
		for (int candy : candies) {
			if (candy > max) {
				max = candy;
			}
		}
		for (int candy : candies) {
			if (candy + extraCandies >= max) {
				results.add(true);
			} else {
				results.add(false);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] candies = { 1, 100};
		int extraCandies = 50;
		List<Boolean> results = new KidsWithCandies().kidsWithCandies(candies, extraCandies);
		for (boolean b : results) {
			System.out.print(b + " ");
		}
	}
}
