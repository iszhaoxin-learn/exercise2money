class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0) + 1;
            if (cnt > nums.length / 2) return num;
            map.put(num, cnt);
        }
        
        return -1;
    }
}