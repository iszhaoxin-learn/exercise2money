class Solution {
    public int thirdMax(int[] nums) {
        Integer s1 = null;
        Integer s2 = null;
        Integer s3 = null;
        for(int i=0; i<nums.length; i++){
            if(s1==null){
                s1 = nums[i];
            }
            else if(s1!=null && nums[i]>=s1){
                if(nums[i]==s1){
                    continue;
                }
                s3 = s2;
                s2 = s1;
                s1 = nums[i];
            }
            else if(s2==null){
                s2 = nums[i];
            }
            else if(s2!=null && nums[i]>=s2){
                if(nums[i]==s2){
                    continue;
                }
                s3 = s2;
                s2 = nums[i];
            }
            else if(s3==null){
                s3 = nums[i];
            }
            else if(s3!=null && nums[i]>=s3){
                if(nums[i]==s3){
                    continue;
                }
                s3 = nums[i];
            }
        }
        return s3!=null?s3:s1;
    }
    public int best(int[] nums) {
        Integer s1 = null;
        Integer s2 = null;
        Integer s3 = null;
        for(Integer n : nums){
            if(n.equals(s1) || n.equals(s2) || n.equals(s3)) continue;

            if(s1==null || n>s1){
                s3 = s2;
                s2 = s1;
                s1 = n;
            }
            else if(s2==null || n>s2){
                s3 = s2;
                s2 = n;
            }
            else if(s3==null || n>s3){
                s3 = n;
            }
        }
        return s3!=null?s3:s1;
    }
}