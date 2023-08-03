package LetCode;

/**
 * ClassName:findTheMiddleIndex1911
 * Description:先求得数组中所有元素之和sum；
 * 遍历数组，取当前下标左边的元素之和left_sum，同时sum减去已遍历元素，比较二者是否相等，相等则返回当前下标；
 * 遍历结束，代表没有中心索引，返回-1；
 * <p>
 * 作者：xiaoyi
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/yf47s/?discussion=D6slGT
 *
 * @Create:2023/6/13 -20:16
 */
public class findTheMiddleIndex1911 {

    public int findMiddleIndex(int[] nums) {
        int length = nums.length;
        int sum = 0;//计算数列的总和
        int leftsum = 0;
        int currentRight = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        for (int i=0; i < length; i++) {
            currentRight = sum - leftsum - nums[i];
            if (currentRight == leftsum) {
                return i;
            }
            leftsum = leftsum + nums[i];
        }
        return -1;
    }

    public int pivotIndex_answer(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int left_sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum - nums[i];
            if(left_sum == sum){
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }

    public int pivotIndex_answer2(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        int rightsum=0;
        //求和
        for(int i : nums){
            sum += i;
        }
        //找中心
        for(int i=0; i<nums.length; i++){
            rightsum = sum - leftSum - nums[i];
            if(leftSum==rightsum) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,1,1,1};
        findTheMiddleIndex1911 findTheMiddleIndex1911 = new findTheMiddleIndex1911();
        System.out.println(findTheMiddleIndex1911.pivotIndex_answer2(arr));

    }
}
