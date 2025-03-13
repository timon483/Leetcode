import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target){

        HashMap numsIndexes = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numsIndexes.containsKey(diff)) {
                return new int[]{(int) numsIndexes.get(diff), i};
            } else {
                numsIndexes.put(nums[i], i);
            }
        }

        return new int[2];
    }


}
