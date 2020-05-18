package minimum.array;

public class MaxPts {
	public int maxScore(int[] cardPoints, int k) {
		int pts[] = new int[cardPoints.length + 1];
		for (int i = 0; i < cardPoints.length; i++) {
			pts[i + 1] = pts[i] + cardPoints[i];
		}
		int sum = 0;
		int front = 1;
		int rear = cardPoints.length;
		while (k > 0) {
			int scoreFirst = pts[front + k - 1] - pts[front - 1];
			int scoreLast = pts[rear] - pts[rear - k];
			if (scoreFirst > scoreLast) {
				sum += cardPoints[front - 1];
				front++;
			} else {
				sum += cardPoints[rear - 1];
				rear--;
			}
			k--;
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] cardPoints = {1,2,-1,4,5,6,1};
		int k = 5;
		System.out.println(new MaxPts().maxScore(cardPoints, k));
	}
}
