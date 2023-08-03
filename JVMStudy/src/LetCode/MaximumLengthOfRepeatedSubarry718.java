package LetCode;

/**
 * ClassName:MaximumLengthOfRepeatedSubarry718
 * Description:在两个整数数组中，找出
 *
 * @Create:2023/7/12 -21:15
 */
public class MaximumLengthOfRepeatedSubarry718 {

    public int findLength(int[] nums1, int[] nums2) {


        return 0;
    }

    public int judgeTheNumOfZero(int[] nums){
        int length = nums.length;
        int zeros=0;
        for (int i = 0; i < length; i++) {
            if (nums[i]==0){
                zeros++;
            }
        }
        return zeros;
    }
}
