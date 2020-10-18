import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import java.util.Arrays;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1(){
        String deadends[] = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        Solution s = new Solution();
        int num = s.openLock(deadends, target);
        System.out.println(num);
    }

}