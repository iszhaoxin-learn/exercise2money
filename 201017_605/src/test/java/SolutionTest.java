import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1(){
        int[] flowered = new int[]{1,0,0,0,0,1};
        int n = 1;
        Solution s = new Solution();
        s.canPlaceFlowers(flowered, n);
    }

}