package LetCode;

/**
 * ClassName:ArrayAndStringFindTheLocation
 * Description: 这个题目没有编号，是学习册当中的题目
 * 题目给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/cxqdh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Create:2023/6/14 -18:50
 */
public class ArrayAndStringFindTheLocation {

    public int searchInsert(int[] nums, int target) {
        int index = 0;//目标的位置
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i]){
                System.out.println("输出");
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        ArrayAndStringFindTheLocation arrayAndStringFindTheLocation = new ArrayAndStringFindTheLocation();
        System.out.println(arrayAndStringFindTheLocation.searchInsert(arr, 2));
    }
}
