package LetCode;

import java.util.Arrays;

/**
 * ClassName:Move0inArry
 * Description:
 *
 * @Create:2023/6/5 -20:20
 */
public class Move0inArry2460 {

    public int[] applyOperations2(int[] nums) {
        int numlength = nums.length;
        for (int i = 0; i < numlength; i++) {
            if (i== numlength -1){//如果已经操作到最后了就直接退出
                break;
            }
            if (nums[i]==nums[i+1]){
                nums[i]= nums[i]*2;
                nums[i+1] = 0;
            }else {
                continue;
            }
        }
        //下面是移动0的操作
        return move0(nums);
    }
    public int[] move0(int[] nums){
        //使用双指针来操作数据交换0
        int Current0 = 0;
        int NextNot0 = 1;
        int length = nums.length;
        for (; Current0 < length; Current0++) {
            //移动Current0找一个0元素
            if (nums[Current0]==0){
                //当前元素是0的话，那么就移动NextNot0找到第一个不是0的
                NextNot0=Current0+1;
                for (;NextNot0 < length;NextNot0++){
                    if (nums[NextNot0] !=0){
                        nums[Current0] = nums[NextNot0];
                        nums[NextNot0] = 0;
                        break;
                    }
                }
            }
            //找到零元素之后，NextNot0去寻找下第一个非0元素
        }
        return nums;
    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        Move0inArry2460 move0inArry2460 = new Move0inArry2460();
        int[] nums = {1,2,2,1,1,0};
        int[] ints = move0inArry2460.applyOperations(nums);
        System.out.println(Arrays.toString(ints));
    }
}
