import java.util.Arrays;
import java.util.HashMap;

/**
 *
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class TwoSum {

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

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(array, target);
        System.out.println(Arrays.toString(result));
    }
}
