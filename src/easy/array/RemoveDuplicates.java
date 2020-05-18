package easy.array;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int cur = 0;
		int i = 1;
		while (i < nums.length) {
			if (nums[i] != nums[cur]) {
				nums[++cur] = nums[i++];
				continue;
			}
			while (i < nums.length && nums[i] == nums[cur]) {
				i++;
			}
			if (i < nums.length) {
				nums[++cur] = nums[i];
			}
		}
		return cur + 1;
	}

	public static void main(String[] args) {
		int nums[] = {1,1,2 };
		int len = new RemoveDuplicates().removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.printf("%d ", nums[i]);
		}
	}
}
