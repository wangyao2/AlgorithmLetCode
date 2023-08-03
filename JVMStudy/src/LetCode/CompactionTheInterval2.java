package LetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:CompactionTheInterval
 * Description: 一个二维数组，把内部的数据挨个合并成为没有重叠的连续区间包含，给二维数组排序
 *
 * @Create:2023/6/15 -20:05
 */
public class CompactionTheInterval2 {
    public int[][] merge(int[][] intervals) {
        int arrlength = intervals.length;
        int[][] result = new int[arrlength][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int resultPoint = 0;
        result[resultPoint][0] = intervals[0][0];//设置吞并起点
        result[resultPoint][1] = intervals[0][1];//设置吞并起点
        for (int i = 0; i < arrlength;) {
            if (result[resultPoint][1]>=intervals[i][1]){//吞并
                i++;
            } else if(result[resultPoint][1]>=intervals[i][0]){//部分吞并
                result[resultPoint][1] = intervals[i][1];//设置吞并起点
                i++;
            }else {//保持不动，处理一下一个数组
                resultPoint++;
                result[resultPoint][0] = intervals[i][0];//设置吞并起点
                result[resultPoint][1] = intervals[i][1];//设置吞并起点
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
        CompactionTheInterval2 compactionTheInterval = new CompactionTheInterval2();
        int[][] a = { {1, 3}, {8, 10}, {2, 6},{15, 18}};
        compactionTheInterval.merge(a);

    }
}
