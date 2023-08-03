package LetCode;

/**
 * ClassName:oneBitAndtwoBit717
 * Description:有两种特殊字符：
 *
 * 第一种字符可以用一比特0 表示
 * 第二种字符可以用两比特（10或11）表示
 * 给你一个以 0 结尾的二进制数组bits，如果最后一个字符必须是一个一比特字符，则返回 true 。

 *
 * @Create:2023/7/12 -20:42
 */
public class oneBitAndtwoBit717 {
    public static void main(String[] args) {
        int[] nums ={1,0,0};
        oneBitAndtwoBit717 oneBitAndtwoBit717 = new oneBitAndtwoBit717();
        boolean oneBitCharacter = oneBitAndtwoBit717.isOneBitCharacter(nums);
        System.out.println(oneBitCharacter);
    }

    public boolean isOneBitCharacter(int[] bits) {
        //先把bit里面，前面的所有0都给去掉。剩下的通过奇偶判断即可
        int length = bits.length;

        for (int i = 0; i < bits.length; i++) {
            if (bits[i]==0){
                length--;
            }
            if (bits[i]==1){
                break;
            }
        }

        if (length==1 || length ==0){return true;}
        if (length % 2 ==1){//如果是奇数
            return true;
        }else {//如果是偶数
            return false;
        }
    }

    public boolean isOneBitCharacter2(int[] bits) {
        int length = bits.length;
        boolean flag= true;
        for (int i = 0; i < length; i++) {
            if (bits[i] ==1){//如果当前处理的元素是1
                i++;//直接就去处理下一个元素
                flag = false;
            }else {//如果当前处理的元素是0
                flag = true;
            }
        }
        return flag;
    }
}
