package study1;

public class plusOne {

    public static void main(String[] args) {
        int[] nums = {9,9,9,9};
        int[] ints = pulsOne1(nums);
        for (int i :ints){
            System.out.println(i);
        }
    }

    public static int[] pulsOne1(int[] nums){
        int length = nums.length;
        if (nums[length-1] ==9){//如果最后一位是9那么就需要考虑进位
            for (int i =length-1;i >= 0;i--){//向前找，找到第一个不是9的地方，然后给他+1
                if (nums[i] == 9){
                    nums[i] = 0;
                }else {//如果这一位不等于9
                    nums[i] = nums[i]+1;
                    return nums;
                }
            }//for循环全遍历结束，说明是全9的数组

            int[] newNums = new int[length+1];
            newNums[0] =1;
            for (int j = 1;j< newNums.length;j++){
                newNums[j] = 0;
            }
            return newNums;
        }else {///如果最后一位不是9，那么就不用进位，直接给他最后一个数加1返回就行
            nums[length-1] = nums[length-1] +1;
            return nums;
        }
    }
}
