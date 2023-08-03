package LetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumSet;

/**
 * ClassName:DialogSearchTheMartic
 * Description:
 *
 * @Create:2023/6/17 -17:59
 */
public class DialogSearchTheMartic {

    public int[] findDiagonalOrder(int[][] mat) {
        int hang = mat.length;
        int lie = mat[0].length;
        int[] result = new int[hang*lie];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < hang; i++) {
            for (int j =0;j<lie ;j++){
                int i1 = judgeThePoing(i, j, mat);
                switch (i1){
                    case 1:
                        
                }

                if (i==0||j==lie){//如果是第0行或者最右边的数，那么就往下走
                    res.add(mat[i][j]);
                }else {



                }
            }
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int judgeThePoing(int i, int j,int[][] mat){
        int hang = mat.length -1;//减一是因为长度和编号之间差1
        int lie = mat[0].length -1;
        if (i==0){//如果是第0行或者最右边的数，那么就往下走
            return 1;
        }else if (i==hang){
            return 3;
        }else if (j==0){
            return 2;
        }else if (j==lie){
            return 4;
        }else {
            return 0;
        }

    }
    public static void main(String[] args) {

    }
}
