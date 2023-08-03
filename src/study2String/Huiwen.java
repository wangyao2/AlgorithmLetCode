package study2String;

public class Huiwen {
    public static void main(String[] args) {
        String s =  "Panama";
//        System.out.println(s.toLowerCase());
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }


    public static boolean isPalindrome(String s){
        if (s.length() <= 1 ){
            return true;
        }
        s = s.toLowerCase();
        int length = s.length();
        char[] temp1 =new char[length];
        char[] temp2 =new char[length];
        int j =0;
        int k =0;
        boolean flag = true;
        char[] chars = s.toCharArray();
        for (int i=0;i < length;i++) {
            if ((chars[i]>=48 && chars[i] <=57)|| (chars[i]>=97 && chars[i] <=122)||(chars[i]>=65 && chars[i] <=90)) {
                //如果要是数字和大小写字母的话，那就保留下来
                temp1[j] = chars[i];
                j++;
            }

            if ((chars[length-1-i]>=48 && chars[length-1-i] <=57)|| (chars[length-1-i]>=97 && chars[length-1-i] <=122)||(chars[length-1-i]>=65 && chars[length-1-i] <=90)) {
                //如果要是数字和大小写字母的话，那就保留下来
                temp2[k] = chars[length-1-i];
                k++;
            }

        }
//
//        String Stmp = temp1.toString();
//        StringBuilder reverse = new StringBuilder(Stmp).reverse();
//        temp2 = reverse.toString().toCharArray();

        for (int i = 0; i < j;i++){
            if (temp1[i] !=temp2[i]){
                flag = false;
            }
        }
        return flag;
    }
}
