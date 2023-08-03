package LetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:MouseAndChese2611
 * Description: 贪心算法，以及利用top-k来解决问题，这里是寻找top-k的下标元素。
 * 寻找top-k的思路，姜宽做的很好，创建一个下标数组，对下标数组排序，排序的方法是使用原始数据大小的比较器来排序。这个比较器的思路很好
 *
 * @Create:2023/6/7 -23:10
 */
public class MouseAndChese2611 {
    public int miceAndCheese2(int[] reward1, int[] reward2, int k) {
        //和我的想法一样，就是用数列相减，然后选取差大的那几个。没想到思路也蛮简单的
        int length = reward1.length;
        int[] miuns = new int[length];
        for (int i = 0; i < length; i++) {
            miuns[i] = reward1[i] - reward2[i];
        }
        int sum = 0;
        int count = 0;
        //下面在minus中找到top k大的数，并记录他们的下标
        int[] tagforMouse1 = findtheTopK_Jiang(miuns, k);
        Arrays.sort(tagforMouse1);
        for (int i = 0; i < length; i++) {
            if (tagforMouse1.length!=0){
                if (count<tagforMouse1.length && i == tagforMouse1[count]) {
                    count++;
                    sum = sum + reward1[i];
                } else {
                    sum = sum + reward2[i];
                }
            }else {
                sum = sum + reward2[i];
            }
        }
        return sum;
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diffs[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diffs);
        for (int i = 1; i <= k; i++) {
            ans += diffs[n - i];
        }
        return ans;
    }
    public int[] findthetopK(int[] a, int k) {//目前失败了，如何寻找前k个最大的数
        int[] tag = new int[k];
        int[] sortedA = Arrays.copyOf(a, a.length);
        int count = 0;
        Arrays.sort(sortedA);
        int previse =-1;
        for (int i = sortedA.length - 1; i >= sortedA.length - k; i--) {
            for (int j = 0; j < a.length;j++) {
                if (sortedA[i] == a[j]) {
                    if (j != previse){
                        tag[count++] = j;
                        previse = j;
                        break;
                    }
                }
            }
        }
        return tag;
    }

    public static int[] findtheTopK_Jiang(int[] arr, int k){
        int n=arr.length;
        int[] tag = new int[k];
        Integer[] tmp=new Integer[n];
        for(int i=0;i<n;i++)
            tmp[i]=i;
        Arrays.sort(tmp,(a,b)->{return arr[b]-arr[a];});
//        Arrays.sort(tmp, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return arr[o1]-arr[o2];
//            }
//        });

        //int[] sorts = Arrays.stream(tmp).mapToInt(Integer::valueOf).toArray();
        int[] sorts = Arrays.stream(tmp).mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < k; i++) {
            tag[i] = sorts[i];
        }
        return tag;
    }
    public static void main(String[] args) {
        int[] reward1 = {2,1};
        int[] reward2 = {1,2};
        MouseAndChese2611 mouseAndChese2611 = new MouseAndChese2611();
        int i = mouseAndChese2611.miceAndCheese2(reward1, reward2, 1);
        System.out.println(i);

    }

}
