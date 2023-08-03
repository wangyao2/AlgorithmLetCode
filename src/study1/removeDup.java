package study1;

public class removeDup {


    public static void main(String[] args) {

        int[] nums = {1,2,2,7,7};
        int i = removeDup.removeDuplicates3(nums);
        //System.out.println(i);
        for (int j = 0;j<i;j++){
            System.out.println(nums[j]);
        }
    }


    public int removeDuplicates(int[] nums) {
        int curNum = 0;
        int curPoint = 0;
        int movNum = 0;
        int movePoint = 0;
        int flag1 = 0;
        int flag2 = 0;

        int[] result = new int[nums.length +1];

        curPoint = 0;
        curNum = nums[0];
        movePoint = 0;//记录下标
        movNum = nums[0];//最开始都在0的位置
        while(true){

            while(curNum == movNum){
                if(movePoint+1 >= nums.length) break;
                movePoint++;
                System.out.println( "movePoint "+  movePoint);
                movNum = nums[movePoint];

            }//退出循环时说明找到了，不相等的那个值



            result[flag1] = curNum;
            flag1++;//存起来当前值，然后记录有一个数
            System.out.println( "flag1 "+  flag1);

            curPoint = movePoint;
            curNum = nums[curPoint];
            movNum = nums[movePoint];
            if(curPoint == nums.length - 1){
                result[flag1] = curNum;
                flag1++;
                break;
            }
        }

        for(int i =0; i< flag1; i++){
            nums[i] = result[i];
            System.out.println("每个元素  "+nums[i]);
        }

        return flag1;

    }
    public static int removeDuplicates2(int[] nums){
        int length = nums.length;
        int index = 0;
        for (int i = 0,j = 1;i < length && j < length;){
            if(nums[i] == nums[j]){
                j++;
            }else {
                index++;
                nums[index] = nums[j];
                i = j++;
            }
        }
        return index + 1;
    }
    public static int removeDuplicates3(int[] nums){
        int index =0;//用来处理下标
        int i =0; //用来暂存当前这个数字
        int j = 1;//用来移动
        //System.out.println("数组长度是： "+nums.length);
        while (i < nums.length && j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                index++;
                nums[index] = nums[j];
                i = j;
                j++;
            }
        }
        return index+1;
    }
    public static int removeDuplicates4(int[] nums){
        int length = nums.length;
        int index =0;//用来处理下标
        for (int i = 0,j = 1;i < length && j < length;){
            if (nums[i] == nums[j]){
                j++;
            }else {
                index++;
                nums[index] = nums[i];
                i = j++;
                //j++;
            }
        }
        return index+1;
    }
}
