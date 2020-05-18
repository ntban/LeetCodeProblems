package easy.array;

import java.util.Arrays;

public class RotateArray {
	public void rotate(int[] a, int k) {
		if (a == null || a.length == 0)
			return;
		k = k % a.length;
		
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		new RotateArray().rotate(a, k);
		System.out.println(Arrays.toString(a));
	}
}
