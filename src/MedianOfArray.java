import java.util.Arrays;

public class MedianOfArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{4};

        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] mergedArray = new int[nums1.length + nums2.length];

        int pointer = 0;
        int l = 0;
        int r = 0;

        while (pointer < mergedArray.length) {
            if (l > nums1.length - 1) {
                mergedArray[pointer] = nums2[r];
                r++;
            }
            else if (r > nums2.length - 1) {
                mergedArray[pointer] = nums1[l];
                l++;
            }
            else if (nums1[l] <= nums2[r]) {
                mergedArray[pointer] = nums1[l];
                l++;
            } else {
                mergedArray[pointer] = nums2[r];
                r++;
            }
            pointer++;
        }

        System.out.println(Arrays.toString(mergedArray));

        int indexLeft = 0;
        int indexRight = 0;

        if (mergedArray.length%2 == 0) {
            indexRight = mergedArray.length/2;
            indexLeft = indexRight - 1;
        } else {
            indexLeft = mergedArray.length/2;
        }
        double result = 0;
        if (indexRight != 0) {
            result = ((double) mergedArray[indexLeft] + (double) mergedArray[indexRight])/2;
        } else {
            result = (double) mergedArray[indexLeft]/2;
        }

        return result;
    }


}
