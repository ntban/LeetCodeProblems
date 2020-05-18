package minimum.array;

import java.util.ArrayList;
import java.util.List;

public class FindDiagonalOrder {
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		List<Integer> result = new ArrayList<>();

		int a[][] = new int[nums.size()][];
		int width = 0;
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> list = nums.get(i);
			a[i] = new int[list.size()];
			if (list.size() > width) {
				width = list.size();
			}
			for (int j = 0; j < list.size(); j++) {
				a[i][j] = list.get(j);
			}
		}
		for (int i = 0; i < a.length; i++) {
			int col = 0;
			int row = i;
			if (col < a[row].length) {
				result.add(a[row][col]);
			}
			while (true) {
				col++;
				row--;
				if (row < 0) {
					break;
				}
				if (col >= a[row].length) {
					continue;
				}
				result.add(a[row][col]);
			}
		}
		for (int j = 1; j < width; j++) {
			int col = j;
			int row = a.length - 1;
			if (col < a[row].length) {
				result.add(a[row][col]);
			}
			while (true) {
				col++;
				row--;
				if (row < 0) {
					break;
				}
				if (col >= a[row].length) {
					continue;
				}
				result.add(a[row][col]);
			}
		}

		int arr[] = new int[result.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = result.get(i);
		}
		return arr;
	}

	static int[][] input(){
		return null;
	}
	
	public static void main(String[] args) {
		int[][] a = input();
		List<List<Integer>> nums = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < a[i].length; j++) {
				list.add(a[i][j]);
			}
			nums.add(list);
		}
		int result[] = new FindDiagonalOrder().findDiagonalOrder(nums);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
