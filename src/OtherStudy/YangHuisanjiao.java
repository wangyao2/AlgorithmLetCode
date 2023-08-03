package OtherStudy;

import java.util.ArrayList;
import java.util.List;

public class YangHuisanjiao {

    public static void main(String[] args) {
        int rowNums = 5;
        List<List<Integer>> lists = generate(5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }


    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> Bigarrays = new ArrayList<>(numRows);

        if ( numRows ==1){
            List<Integer> arr1 = new ArrayList<>(1);
            arr1.add(1);
            Bigarrays.add(arr1);
            return Bigarrays;
        }
        if (numRows ==2 ){
            List<Integer> arr1 = new ArrayList<>(1);
            List<Integer> arr2 = new ArrayList<>(2);
            arr1.add(1);
            arr2.add(1);
            arr2.add(1);
            Bigarrays.add(arr1);
            Bigarrays.add(arr2);
            return Bigarrays;
        }
        if (numRows>=3 ){
            List<Integer> arr1 = new ArrayList<>(1);
            List<Integer> arr2 = new ArrayList<>(2);
            arr1.add(1);arr2.add(1);arr2.add(1);
            Bigarrays.add(arr1);
            Bigarrays.add(arr2);

            for (int i = 2; i < numRows ; i++){//从第3行开始，也就是标号为2的那一行继续往下写
                ArrayList<Integer> smallArry = new ArrayList<>(i + 1);

                smallArry.add(1);//每一行第一个元素必须是1
                List<Integer> UpFloor = Bigarrays.get(i - 1);//获取到上一层的全部元素
                for (int j =1; j< i; j++){ //每一行的
                    smallArry.add(UpFloor.get(j)+UpFloor.get(j-1));
                }
                smallArry.add(1);//每一行最后一个元素必须是1

                Bigarrays.add(smallArry);
            }
        }else {
            System.out.println("没法输出一个正确结果");

        }
        return Bigarrays;
    }
}
