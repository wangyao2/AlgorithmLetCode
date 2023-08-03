package study1;

import javax.net.ssl.CertPathTrustManagerParameters;

public class MoveZero {

    public static void main(String[] args) {
        int[] nums = {1,2,0,3,4};
        moveZeroes(nums);
        for (int i :nums){
            System.out.println(i);
        }
    }
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length ==0){
            return;
        }
        int i =0;
        int j =0;
        int tmp = 0;//用来存放中间变量作为交换

        while (j<length){
            if (nums[i]!=0){
                i++;
                j++;
            }else {//如果当前的nums是0的话，那么就去找下一个非0元素
                for(j=i+1;j<length ; ){//去找i后面第一个非0元素
                    if (nums[j]!=0){
                        exchane(nums,i,j);
                        i++;
                        //j=i;
                        break;
                    }
                    j++;
                }
            }
        }
    }
    public static void exchane(int[] nums,int i ,int j){
        int temp = 0;
        temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
