package study2String;

import java.util.HashMap;

public class FindTheFistSingle {


    public static void main(String[] args) {

        //String s1 = "loveleetcode";
        String s1 = "aac";

        int i = firstUniqChar(s1);
        System.out.println(i);

    }
    public static  int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        if (s.length() ==1 ) return 0;
        boolean flag1  = false;
        boolean flag2 = false;
        char cc = ' ';
        for (int i =0; i < s.length() ;i++){
            cc = s.charAt(i);
            int j =i +1;
            while (j < s.length()){
                if (cc == s.charAt(j)) break;//找到了相同的那就break
                if (j == s.length() -1 ) flag1 = true;//为true，那说明，找到头也没找到重复的
                j++;
            }

            int m = i -1;
            while (m >=0 ){
                if (cc == s.charAt(m)) break;//找到了相同的那就break
                if (m == 0)  flag2 = true; //为true，说明找到首也没找到重复的
                m--;
            }
            if (flag1 == true && i ==0){
                return 0;
            }
            if (flag2 == true && i ==s.length()-1){
                return i;
            }
            if (flag1 && flag2){
                return i;
            }
            flag1 = false;
            flag2 = false;

        }
        return  -1;
    }
}
