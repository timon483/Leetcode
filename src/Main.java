import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {



        ListNode soloListNode = new ListNode(1);

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(9, listNode1);
        ListNode listNode3 = new ListNode(9, listNode2);
/*        ListNode listNode4 = new ListNode(9, listNode3);
        ListNode listNode5 = new ListNode(9, listNode4);
        ListNode listNode6 = new ListNode(9, listNode5);
        ListNode listNode7 = new ListNode(9, listNode6);
        ListNode listNode8 = new ListNode(9, listNode7);
        ListNode listNode9 = new ListNode(9, listNode8);
        ListNode listNode10 = new ListNode(1, listNode9);*/





/*        ListNode listNode2 = new ListNode(4, listNode3);
        ListNode listNode1 = new ListNode(2, listNode2);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6, listNode4);
        ListNode listNode5 = new ListNode(5, listNode6);*/

      //  ListNode test = addTwo(soloListNode, listNode3);

       // System.out.println(test);

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

    public static ListNode addTwo(ListNode l1, ListNode l2) {


        ListNode result = sumTwoNodes(l1, l2, 0);

        return result;

    }



    public static ListNode sumTwoNodes(ListNode l1, ListNode l2, int rest) {

        if (l1.next != null && l2.next != null) {
            int sum = l1.val + l2.val + rest;
            return new ListNode(valueWithoutRest(sum), sumTwoNodes(l1.next, l2.next, isRest(sum)));
        }

        if (l1.next == null && l2.next != null) {
            int sum = l1.val + l2.val + rest;
            return new ListNode(valueWithoutRest(sum), sumOneNode(l2.next, isRest(sum)));
        } else if (l1.next != null && l2.next == null) {
            int sum = l1.val + l2.val + rest;
            return new ListNode(valueWithoutRest(sum), sumOneNode(l1.next, isRest(sum)));

        }

        int sum = l1.val + l2.val + rest;
        if (sum < 10) {
            return new ListNode(sum);
        } else {
            return new ListNode(valueWithoutRest(sum), new ListNode(sum/10));
        }

    }

    public static ListNode sumOneNode(ListNode listNode, int rest) {
        int sum = listNode.val + rest;
        if (listNode.next != null) {
            sum = listNode.val + rest;
            return new ListNode(valueWithoutRest(sum), sumOneNode(listNode.next, isRest(sum)));
        } else {
            if (sum < 10) {
                return new ListNode(sum);
            } else {
                return new ListNode(valueWithoutRest(sum), new ListNode(sum/10));
            }
        }
    }

    public static int isRest(int sum) {
        if (sum >= 10) {
            return 1;
        }
        return 0;
    }

    public static int valueWithoutRest(int sum) {
        if (sum >= 10) {
            return sum - 10;
        }
        return sum;
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
