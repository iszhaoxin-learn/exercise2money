class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int i = 0, j = 0;
        
        while (j < nums.length) {
            // can not be nums[j] > nums[j - 2]
            // e.g. nums: [1,1,1,2,2,3]
            if (i < 2 || nums[j] > nums[i - 2]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        
        return i;
    }
}