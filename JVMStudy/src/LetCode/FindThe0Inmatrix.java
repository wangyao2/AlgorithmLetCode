package LetCode;

import java.util.ArrayList;

/**
 * ClassName:FindThe0Inmatrix
 * Description: 把0位置元素的数，所在的行、列全部都
 *
 * @Create:2023/6/16 -19:55
 */
public class FindThe0Inmatrix {
    public static void main(String[] args) {


    }

    public void setZeroes(int[][] matrix) {
        int hangshu = matrix.length;
        int lieshu = matrix[0].length;
        int[][] tempM = new int[hangshu][lieshu];
        ArrayList<Integer> rowToClear = new ArrayList<>();
        ArrayList<Integer> columToClear = new ArrayList<>();

        //i是行数，j是列数
        for (int i = 0; i < hangshu; i++) {
            for (int j = 0; j < lieshu; j++) {
                if (matrix[i][j] == 0){
                    rowToClear.add(i);
                    columToClear.add(j);
                }
            }
        }
        for (Integer integer : rowToClear) {
            refreshTheRow(matrix, integer);
        }
        for (Integer integer : columToClear) {
            refreshTheColumn(matrix, integer);
        }
    }

    public void refreshTheRow(int[][] matrix,int row){
        int liechangdu = matrix[0].length;
        for (int i = 0; i < liechangdu; i++) {
            matrix[row][i] = 0;
        }
    }
    public void refreshTheColumn(int[][] matrix,int col){
        int hangshu = matrix.length;
        for (int i = 0; i < hangshu; i++) {
            matrix[i][col] = 0;
        }
    }

}
