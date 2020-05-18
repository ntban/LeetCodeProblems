package minimum.array;

import java.util.ArrayList;

public class MinFrogs {
	public int minNumberOfFrogs(String croakOfFrogs) {
		char[] croaks = croakOfFrogs.toCharArray();
		int count = 0;
		ArrayList<Frog>[] freeFrogs = new ArrayList[CROAK.length];
		for (int i = 0; i < CROAK.length; i++) {
			freeFrogs[i] = new ArrayList<>();
		}
		for (int i = 0; i < croaks.length; i++) {
			for (int j = 0; j < CROAK.length; j++) {
				if (croaks[i] == CROAK[j]) {
					int curOne = j - 1;
					if (curOne == -1) {
						curOne = CROAK.length - 1;
					}
					if (freeFrogs[curOne].size() > 0) {
						// greedy, treat all frogs in same croak in same way
						int lastIndex = freeFrogs[curOne].size() - 1;
						Frog lastFrog = freeFrogs[curOne].remove(lastIndex);
						freeFrogs[j].add(lastFrog);
					} else if (j == 0) {
						// if no free frog and it's the start croak
						freeFrogs[0].add(new Frog());
					} else {
						// no way to get all the croak
						return -1;
					}
				}

			}
		}
		// all validate frog must be in the last array
		for (int i = 0; i < CROAK.length - 1; i++) {
			if (freeFrogs[i].size() > 0) {
				return -1;
			}
		}
		return freeFrogs[CROAK.length - 1].size();
	}

	char CROAK[] = { 'c', 'r', 'o', 'a', 'k' };

	class Frog {
		boolean free;
		int cur;

		Frog() {
			free = true;
			cur = 0;
		}
	}

	public static void main(String[] args) {
		String croakOfFrogs = "croakcroak";
		System.out.println(new MinFrogs().minNumberOfFrogs(croakOfFrogs));
	}
}
