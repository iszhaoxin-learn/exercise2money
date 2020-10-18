import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public double[] probalities;

    public Solution(int[] w) {
        int sum = 0;
        probalities = new double[w.length];
        for(int i=0; i<w.length; i++){
            sum += w[i];
        }
        for(int i=0; i<w.length; i++){
            probalities[i] = (i==0)?(double)w[i]/sum:(double)w[i]/sum+probalities[i-1];
        }
    }

    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(this.probalities, Math.random()))-1;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
/**
 * 这个题的重点在于如何使用java中的随机数，并将其和权重结合在一起
 * 1. 首先我们需要知道，Math.random()返回[0,1]的随机数
 * 2. Arrays.binarySearch 是二分搜索，其中第一个变量必须是排序数组
 * 3. 其次，Arrays.binarySearch虽然是搜索函数，但是key可以不存在于array当中，可以返回比key小的index+1的index
 */