package study1;

import java.util.Arrays;

public class OnlyOneTimes {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,6};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        if (nums.length ==1){//首先题目说他是非空的，然后长度是1直接返回，而且长度只可能是奇数个
            return nums[0];
        }

        int aim = 0;
        int i =0;
        int j =1;
        Arrays.sort(nums);

        for ( ;j<nums.length;){
            if (nums[i]!=nums[j]){
                return nums[i];
            }else {
                i=i+2;
                j=j+2;
            }
        }
        aim = nums[nums.length-1];
        return aim;
    }
}
