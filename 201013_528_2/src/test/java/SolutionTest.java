import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1(){
        double[] nums = new double[]{10,12,5,3,20};
//        Solution s  = new Solution(nums);
//        System.out.println(s.probalities[0]);
//        System.out.println(Math.random());
        int a = Math.abs(Arrays.binarySearch(nums, 1.2193));
        System.out.println(a);
    }

}