// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Follow up:

// Could you solve this problem without using the library's sort function?
// Could you come up with a one-pass algorithm using only O(1) constant space?
 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]
// Example 3:

// Input: nums = [0]
// Output: [0]
// Example 4:

// Input: nums = [1]
// Output: [1]
 

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is 0, 1, or 2.

class Solution {
    public void sortColors(int[] A) {
        // count
        int[] counts = new int[3];
        for (int i: A) {
            counts[i]++;
        }
        // fill
        for (int i = 0; i < A.length; i++) {
            if (i < counts[0]) {
                A[i] = 0;
            } else if (i < counts[0] + counts[1]) {
                A[i] = 1;
            } else {
                A[i] = 2;
            }
        }
    }
}