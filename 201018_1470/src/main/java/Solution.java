class Solution {
    public int[] shuffle(int[] nums, int n) {
        int news[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i<n) news[i*2] = nums[i];
            else news[(i-n)*2+1] = nums[i];
        }
        return news;
    }

    public int[] shuffle2(int[] nums, int n) {
        for (int i = 0; i < n; ++i) {
            nums[i + n] |= (nums[i] << 10);
        }
        for (int i = 0; i < n; ++i) {
            nums[i * 2] = (nums[i + n] & 0xFFC00) >> 10;     // 11111111110000000000 == 0xFFC00
            nums[i * 2 + 1] = nums[i + n] & 0x003FF;        // 00000000001111111111 == 0x003FF
        }
        return nums;
    }
}


/**
 * 这个题的正确方法是使用位操作，对于这种对半分的问题，完全可以将两个数字的信息通过移位放在一个数字中处理
 * 再通过移位恢复原有信息
 */