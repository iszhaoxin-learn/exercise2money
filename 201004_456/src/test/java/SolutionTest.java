//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testFunc(){
        Solution test = new Solution();
        int[] nums = new int[]{1,2,3,4};
        test.find132pattern(nums);

    }
}