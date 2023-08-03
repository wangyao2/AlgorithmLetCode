package DataStructer;

import java.util.Arrays;

/**
 * ClassName:MergeSort1
 * Description:
 *
 * @Create:2023/7/27 -10:03
 */
public class MergeSort1 {

    public static void main(String[] args) {

        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];

        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    //分+合并
    public static void mergeSort(int[] arr, int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right)/2;//生成中间索引
            //向左边去进行递归分解
            mergeSort(arr,left,mid,temp);
            //向左边去进行递归分解
            mergeSort(arr,mid+1,right,temp);
            merger(arr,left,mid,right,temp);
        }
    }
    /* left 左边序列的初始索引，mid 中间索引， right 最后边的那个索引， temp用来中转存放排序结果的数组
    * 这个函数用来处理所有数据归并成两个大数组之后的最后一轮的操作*/
    public static void merger(int[] arr, int left,int mid,int right,int[] temp){
        //输出归并的次数
        System.out.println("归并+1");//合并的次数是数组长度减一
        int i = left;
        int j = mid +1; //初始化左边序列和右边序列，使用i,j双指针完成归并排序
        int t =0;//这个t用来指示temp临时数组中的位置

        //先把左右两边（两个有序的大数组）的数据，填充到temp数组
        //直到左右两边的序列，有一侧的所有数据处理完毕之后。我们才停止循环
        while (i <=mid && j<=right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++; i++;
            }else {
                temp[t] = arr[j];
                t++; j++;
            }
        }
        //上面的循环跑完之后，我们再看看左边右边这两个大数组，哪边有剩余，有剩余的数组就直接安排默认顺序依次全部填充到temp数组中
        while (i<= mid){//左边的序列还有剩余的元素
            temp[t] = arr[i];
            i++;t++;
        }
        while (j<= right){//左边的序列还有剩余的元素
            temp[t] = arr[j];
            j++;t++;
        }
        //最后把temp数组放回到arr[]数组当中
        t=0;
        int templeft = left;
        System.out.println("输出每次归并时候被处理的元素：左边" + templeft +" 右边 "+ right);
        while (templeft<=right){
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }

    }
}
