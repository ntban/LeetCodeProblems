package easy.array;

import java.util.HashMap;

public class TwoSums {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && nums[i] * 2 == target) {
				return new int[] { map.get(nums[i]), i };
			}
			map.put(nums[i], i);
		}
		for (int key : map.keySet()) {
			if (map.containsKey(target - key)) {
				return new int[] { map.get(key), map.get(target - key) };
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = {3, 3 };
		int target = 6;
		int result[] = new TwoSums().twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}
}
