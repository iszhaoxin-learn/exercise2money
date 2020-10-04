import java.util.*;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int s3 = (int) -1e9;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=nums.length-1; i>=0; i--){
            if( nums[i] < s3 ) return true;
            while(!st.isEmpty() && nums[i]>st.peek()){
                s3 = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
    }
}