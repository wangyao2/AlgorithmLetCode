package LetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:CompactionTheInterval
 * Description: 一个二维数组，把内部的数据挨个合并成为没有重叠的连续区间包含，给二维数组排序
 *
 * @Create:2023/6/15 -20:05
 */
public class CompactionTheInterval {
    public int[][] merge(int[][] intervals) {
        int arrlength = intervals.length;
        int[][] result = new int[arrlength][2];
        //int[][] sortedArray = (int[][])Arrays.stream(intervals).sorted(Comparator.comparingInt(arr -> arr[0])).toArray();
        int[][] sortedArray = Arrays.stream(intervals).sorted(Comparator.comparingInt(arr -> arr[0])).toArray(int[][]::new);
        //int[][] sortedArray = intervals;
        int resultPoint = 0;
        result[resultPoint][0] = sortedArray[0][0];//设置吞并起点
        result[resultPoint][1] = sortedArray[0][1];//设置吞并起点
        for (int i = 0; i < arrlength;) {
            if (result[resultPoint][1]>=sortedArray[i][1]){//吞并
                i++;
            } else if(result[resultPoint][1]>=sortedArray[i][0]){//部分吞并
                result[resultPoint][1] = sortedArray[i][1];//设置吞并起点
                i++;
            }else {//保持不动，处理一下一个数组
                resultPoint++;
                result[resultPoint][0] = sortedArray[i][0];//设置吞并起点
                result[resultPoint][1] = sortedArray[i][1];//设置吞并起点
            }
        }
        int[][] newresult = new int[resultPoint+1][2];
        for (int i = 0; i <= resultPoint; i++) {
            newresult[i]=result[i];
        }
        return newresult;
    }


    public void sortTheArry(int[][] intervals){
        for (int i = 0; i < intervals.length; i++) {

        }
    }
    public static void main(String[] args) {
        int[][] result = {{1,2},{2,3},{4,6}};
        CompactionTheInterval compactionTheInterval = new CompactionTheInterval();
        int[][] a = { {1, 3}, {8, 10}, {2, 6},{15, 18}};
        compactionTheInterval.merge(a);

    }
}
