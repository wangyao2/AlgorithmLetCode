package study1;

public class RotateMatrix {


    public static void main(String[] args) {
//        int[][] matox = {
//                {5,1,9,11},
//                {2,4,8,10},
//                {13,3,6,7},
//                {15,14,12,16}};
        int[][] matox = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(matox);
        for (int[] aMatox : matox) {
            for (int j = 0; j < matox.length; j++) {
                System.out.println(aMatox[j]);
            }
        }
        //System.out.println(5/2);
    }
    public static void rotate(int[][] matrix) {
        int lie =0;
        int length = matrix.length;
        int Q =0;
        int loop=0;
        int m=0,n =0;
        int MaxtrixBinchang = matrix.length;//方阵一边之长
        if (MaxtrixBinchang <=1) return;//没有元素的矩阵和1个元素的矩阵直接回去

        if (MaxtrixBinchang %2 ==0){ //处理偶数阵看看情况,小心2阶矩阵
            for(int ii = 0;ii< length/2;ii++){//最外圈这个控制现在是第几个循环，是第几层嵌套
                m=m-1;//m用来控制,这一行的下一个元素
                for (;lie < length-1-n;){//里面这个循环用来转移数据，按照行数量来遍历
                    Q = matrix[loop][lie];                                      //步骤1

                    matrix[loop][lie] = matrix[length-1-lie][loop];                 //步骤2，列号不变,第一环 就是0 第二环就是 1

                    matrix[length-1-lie][loop]  = matrix[length-1-loop][length-1-lie]; //步骤3，行号不变，第一环就是lenth-1  第二环就是lentg-1-1

                    matrix[length-1-loop][length-1-lie] = matrix[lie][length-1-loop];                 //步骤4，列号不变，第一环 就是lenth-1  第二环就是 lentg-1-1

                    matrix[lie][length-1-loop] = Q;           //步骤5，还原回去

                    lie = lie+1;
                }
                loop = loop+1;
                lie = loop;
                n++;
            }
        }else {//处理奇数阵
            for(int ii = 0;ii< length/2 + 1;ii++){//最外圈这个控制现在是第几个循环，是第几层嵌套
                m=m-1;//m用来控制,这一行的下一个元素
                if (ii == length/2){
                    break;
                }
                for (;lie < length-1-n;){//里面这个循环用来转移数据，按照行数量来遍历
                    Q = matrix[loop][lie];                                      //步骤1

                    matrix[loop][lie] = matrix[length-1-lie][loop];                 //步骤2，列号不变,第一环 就是0 第二环就是 1

                    matrix[length-1-lie][loop]  = matrix[length-1-loop][length-1-lie]; //步骤3，行号不变，第一环就是lenth-1  第二环就是lentg-1-1

                    matrix[length-1-loop][length-1-lie] = matrix[lie][length-1-loop];                 //步骤4，列号不变，第一环 就是lenth-1  第二环就是 lentg-1-1

                    matrix[lie][length-1-loop] = Q;           //步骤5，还原回去

                    lie = lie+1;
                }
                loop = loop+1;
                lie = loop;
                n++;
            }

        }
    }
}
