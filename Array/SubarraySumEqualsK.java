
/*
sum[i, j] = sum[0, j] - sum[0, i - 1]
*/
public class Solution {
	public int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// what is sum - k?? -> A: sum - (sum - k) == k 
			// so, if (sum - k) exist, it means there is a subarray equals k
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
}