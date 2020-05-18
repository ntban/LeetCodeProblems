package minimum.array;

public class MaxDiffChangeInt {
	public int maxDiff(int num) {
		int arr[] = new int[10];
		int minNum[] = new int[10];
		int maxNum[] = new int[10];
		
		int count = 0;
		int n = num;
		while (n > 0) {
			arr[count] = n % 10;
			minNum[count] = n % 10;
			maxNum[count] = n % 10;
			count++;
			n /= 10;
		}
		int beforeChange = -1;
		int afterChange = -1;
		for (int i = count - 1; i >= 0; i--) {
			if (i == count - 1 && arr[i] != 1) {
				beforeChange = arr[i];
				afterChange = 1;
				break;
			} else if (i != count - 1 && arr[i] != 0 && arr[i] != arr[count-1]) {
				beforeChange = arr[i];
				afterChange = 0;
				break;
			}
		}
		int minResult = num;
		if (beforeChange != -1 && afterChange != -1) {
			minResult = getNum(minNum, count, beforeChange, afterChange);
		}
		
		beforeChange = -1;
		afterChange = -1;
		for (int i = count - 1; i >= 0; i--) {
			if (arr[i] != 9) {
				beforeChange = arr[i];
				afterChange = 9;
				break;
			}
		}
		int maxResult = num;
		if (beforeChange != -1 && afterChange != -1) {
			maxResult = getNum(maxNum, count, beforeChange, afterChange);
		}
		return maxResult - minResult;
	}

	private int getNum(int[] arrNum, int count, int beforeChange, int afterChange) {
		int p = 1;
		int result = 0;
		for (int i = 0; i < count; i++) {
			if(beforeChange == arrNum[i]) {
				arrNum[i] = afterChange;
			}
			result += arrNum[i] * p;
			p *= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int num = 100000000;
		System.out.println(new MaxDiffChangeInt().maxDiff(num));
	}
}
