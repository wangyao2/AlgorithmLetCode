package study1;

import java.util.HashMap;

public class containDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1};
        boolean b = containsDuplicate(nums);
        System.out.println(b);

    }


    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> Sites = new HashMap<Integer, Integer>();
        // 添加键值对
        for (int i =0;i < nums.length;i++){
            if (Sites.containsKey(nums[i])){
                return true;
            }else {
                Sites.put(nums[i],null);
            }
        }
        return false;
    }
}
