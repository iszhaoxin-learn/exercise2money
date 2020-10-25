import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        int size = 1;
        int left = 0;
        int right = 0;
        Map<Integer, Boolean> checkList = new HashMap<Integer, Boolean>();

        for(int i: nums){
            checkList.put(i, false);
        }
        for(int i : nums){
            if(checkList.get(i)==true){
                continue;
            }
            right = i;
            checkList.put(i, true);
            int k = i-1;
            while(checkList.containsKey(k)){
                checkList.put(k, true);
                k-=1;
            }
            if(k==2147483646){
                size = Math.max(size,1);
                continue;
            }
            left = k+1;
            size = Math.max(size,right-left+1);
        }
        return size;
    }
}