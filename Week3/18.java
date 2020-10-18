class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m++], nums[n--]));
                        res.add(quad);
                        while (m < n && nums[m] == nums[m - 1]) m++;
                        while (m < n && nums[n] == nums[n + 1]) n--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        
        return res;
    }
}