package study1;

public class rotateArray {

    public static void main(String[] args) {
        int[] nums ={1,2};
        rotate(nums,10);

    }

    public static void rotate(int[] nums, int k) {
        if (nums.length <= 1){
            return ;
        }

        int length = nums.length;
        if (k >= length){
            k = k%length;
        }
        int[] tmpk = new int[k];
        int[] middle = new int[length];
        for (int i =0;i < k;i++){
            tmpk[i]=nums[length-1-i];//tmp [7 6 5 4]
        }
        for (int i =0;k+i < length ;i++){
            middle[k+i] =  nums[i];
        }
        for (int i =0;i < k;i++){
            middle[i] = tmpk[tmpk.length-1-i];
        }
        System.arraycopy(middle, 0, nums, 0, nums.length);

        for (int i =0;i < length;i++){

            System.out.println(nums[i]);
        }
    }
}
