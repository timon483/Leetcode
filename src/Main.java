import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String test = "aabaab!bb";
        int result  = lengthOfLongestSubstring(test);
        System.out.println(result);

    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> characters = new HashMap<>();
        int result = 0;

        ArrayList<Integer> listOfResult = new ArrayList();

        for (int i = 0; i < s.length(); i++) {
            result++;
            if (!characters.containsKey(s.charAt(i))) {
                characters.put(s.charAt(i), result);
                listOfResult.add(result);

            } else {
                int k = characters.get(s.charAt(i));

                result  -= k;


                for (Character character : characters.keySet()) {
                    characters.put(character, (int) characters.get(character) - k);
                }


                characters.put(s.charAt(i), result);

                characters.entrySet().removeIf(entry -> entry.getValue() <= 0);
                listOfResult.add(result);

            }
        }

        int max = Collections.max(listOfResult);

        return max;

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
