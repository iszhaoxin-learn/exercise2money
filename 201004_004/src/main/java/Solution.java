
import java.util.Arrays;

class Solution{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = merge(nums1, nums2);
        quicksort(nums, 0, nums.length-1, nums.length-1);
        if(nums.length%2==0){
            return (float)(nums[nums.length/2-1]+nums[nums.length/2])/2;
        }
        else
            return nums[(int)(nums.length/2)];
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return findMedianSortedArrays2(nums1, nums2, 0, 0 , nums1.length, nums2.length);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2, int low1, int low2, int high1, int high2) {
        if(nums1[low1]>nums2[low2]){

        }
    }
    public void quicksort(int[] nums, int low, int high, int base){
        int current_high = low;
        for(int i=low; i<=high; i++){
            if(nums[i] < nums[base]){
                if(i==current_high){
                    current_high += 1;
                    continue;
                }
                swap(nums, i, current_high);
                current_high += 1;
            }
        }
        swap(nums, base, current_high);
        if(low<current_high-1)
            quicksort(nums, low, current_high-1, current_high-1);
        if(current_high+1<high)
            quicksort(nums, current_high+1, high, high);
    }
    public void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
    public int[] merge(int[] ...arrays) {
        int size = 0;
        for ( int[] a: arrays )
            size += a.length;

        int[] res = new int[size];

        int destPos = 0;
        for ( int i = 0; i < arrays.length; i++ ) {
            if ( i > 0 ) destPos += arrays[i-1].length;
            int length = arrays[i].length;
            System.arraycopy(arrays[i], 0, res, destPos, length);
        }

        return res;
    }
}
