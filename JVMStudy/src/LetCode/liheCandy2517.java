package LetCode;

import java.util.Arrays;

/**
 * ClassName:liheCandy2517
 * Description: 二分法，最大最小问题
 *
 * @Create:2023/6/1 -22:27
 */
public class liheCandy2517 {
    /*
给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
返回礼盒的 最大 甜蜜度。

输入：price = [13,5,1,8,21,2], k = 3
输出：8
解释：选出价格分别为 [13,5,21] 的三类糖果。
礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
可以证明能够取得的最大甜蜜度就是 8 。
     */
    /*
        我的思路：排序后找到k等分点，k-1等分点的最大差距就是最大甜蜜度
        k=2，那就是端点
        k=3，那就是中点 二等分点
        k=4，那应该是 三等分点，每个等分点都找到之后，分别计算最近两个等分点的差

        注意边界条件
     */
    public int maximumTastiness(int[] price, int k) {
        charuSort(price);//Java中对数组直接操作，和C语言中一样，是对指针操作的，得到排序后的价格
        findThe_Kth_Point_And_generateThe_POINTlIST(price,k);

        return 0;
    }

    private void findThe_Kth_Point_And_generateThe_POINTlIST(int[] price, int k) {
        //此函数用来寻找数组的k等分点
        int m = k-1;//3个点就是找中点
        //编写k等分点的查找逻辑
        int Pricelength = price.length;
        //声明一个数组，存储这个k等分点
        //考虑余数等等
        int shang = Pricelength / m;
        int yushu = Pricelength % m;


    }

    public int calculateThe_M_thMax(int[] m_th_price){

        return 0;
    }


    public static void charuSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j > 0 && A[j] < A[j - 1]) {
                int t = A[j];
                A[j] = A[j - 1];
                A[j - 1] = t;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        liheCandy2517 liheCandy2517 = new liheCandy2517();
        int[] price = {13,5,1,8,21,2};
        System.out.println(Arrays.toString(price));
        charuSort(price);
        System.out.println(Arrays.toString(price));
        int k =3;
        int output = liheCandy2517.maximumTastiness(price, k);
        System.out.println(output);

        System.out.println(Integer.MIN_VALUE);
    }

}
