package study2String;

public class ReverseString {


    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o','o'};
        //reverseString(s);
//        for (char c : s) {
//            System.out.println(c);
//        }


        int i = 15 ^ 15 ^ 15;
        System.out.println(i);

    }

    public static void reverseString(char[] s) {//对称交换
        int length = s.length;
        if (length <= 0 ) return;
        char tmp =' ';
        for(int ii =0;ii < length /2 ;ii++){
            tmp = s[ii];
            s[ii] = s[length -1-ii];
            s[length -1-ii] = tmp;
        }
    }
}
