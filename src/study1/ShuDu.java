package study1;

import javax.sound.midi.Soundbank;

public class ShuDu {



    public static void main(String[] args) {
        char[][] board ={
                 {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','9'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        //int i = FindTheGridNum(8, 8);
        //System.out.println("数组在第 "+i+"个格子！");
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }


    public static boolean isValidSudoku(char[][] board) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        int GridNum = 0;
        for (int hang = 0; hang < 9; hang++) {

            for (int lie = 0; lie < 9; lie++) {//遍历所有元素进行行列和格子内的判断
                System.out.println("当前正在处理第行： "+hang+" 第列个元素  "+lie);
                GridNum = FindTheGridNum(hang, lie);
                flag1 = CompareHang(hang, lie, board);
                System.out.println("行的"+flag1);
                flag2 = CompareLie(hang, lie, board);
                System.out.println("列的"+flag2);
                flag3 = CompareGrid(hang, lie, GridNum, board);
                System.out.println("格子内"+flag3);

                if(!(flag1 && flag2 && flag3)){
                    return false;
                }
            }
        }
        return true;
    }

    public static int FindTheGridNum(int hang, int lie) {
        int res = 0;
        if (hang >= 6) {
            switch (lie) {
                case 0:
                    res = 7;
                    break;
                case 1:
                    res = 7;
                    break;
                case 2:
                    res = 7;
                    break;

                case 3:
                    res = 8;
                    break;
                case 4:
                    res = 8;
                    break;
                case 5:
                    res = 8;
                    break;

                case 6:
                    res = 9;
                    break;
                case 7:
                    res = 9;
                    break;
                case 8:
                    res = 9;
                    break;
            }
        } else if (hang >= 3) {
            switch (lie) {
                case 0:
                    res = 4;
                    break;
                case 1:
                    res = 4;
                    break;
                case 2:
                    res = 4;
                    break;

                case 3:
                    res = 5;
                    break;
                case 4:
                    res = 5;
                    break;
                case 5:
                    res = 5;
                    break;

                case 6:
                    res = 6;
                    break;
                case 7:
                    res = 6;
                    break;
                case 8:
                    res = 6;
            }
        } else {
            switch (lie) {
                case 0:
                    res = 1;
                    break;
                case 1:
                    res = 1;
                    break;
                case 2:
                    res = 1;
                    break;

                case 3:
                    res = 2;
                    break;
                case 4:
                    res = 2;
                    break;
                case 5:
                    res = 2;
                    break;

                case 6:
                    res = 3;
                    break;
                case 7:
                    res = 3;
                    break;
                case 8:
                    res = 3;
                    break;
            }
        }
        return res;
    }

    public static boolean CompareHang(int hang, int lie, char[][] board) {
        for (int i = 0;i < 9; i++) {
            if (i ==lie) continue;
            if (board[hang][i]=='.') continue;
            if (board[hang][lie] == board[hang][i]) {//如果有相等的，就说明说不合法的
                return false;
            }
        }
        return true;
    }

    public static boolean CompareLie(int hang, int lie, char[][] board) {
        for (int i = 0;i < 9; i++) {
            if (i ==hang) continue;
            if (board[i][lie]=='.') continue;
            if (board[hang][lie] == board[i][lie]) {
                return false;
            }
        }
        return true;
    }

    public static boolean CompareGrid(int hang, int lie, int gridNum, char[][] board) {
        boolean flag = true;
        if (gridNum ==1){
            for (int i =0;i<3;i++){
                for (int j =0;j<3;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;
                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==2){
            for (int i =0;i<3;i++){
                for (int j =3;j<6;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==3){
            for (int i =0;i<3;i++){
                for (int j =6;j<9;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==4){
            for (int i =3;i<6;i++){
                for (int j =0;j<3;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==5){
            for (int i =3;i<6;i++){
                for (int j =3;j<6;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==6){
            for (int i =3;i<6;i++){
                for (int j =6;j<9;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==7){
            for (int i =6;i<9;i++){
                for (int j =0;j<3;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==8){
            for (int i =6;i<9;i++){
                for (int j =3;j<6;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }else if (gridNum ==9){
            for (int i =6;i<9;i++){
                for (int j =6;j<9;j++){
                    if (j == lie && i==hang) continue;
                    if (board[i][j]=='.') continue;

                    if (board[hang][lie] == board[i][j]){
                        flag =false;
                    }
                }
            }
        }
        return flag;
    }

    ;
}
