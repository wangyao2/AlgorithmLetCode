package study2String;

public class ReverseIntStr {
    public static void main(String[] args) {
        int m = -987654321;
        int i = reInt(m);
        System.out.println(i);
    }

    public static int reInt(int m){
        int result = 0;
        String s2 = "";
        if (m ==0) return 0;
        if (m>0){
            String s1 = "" + m;
            StringBuilder sb = new StringBuilder(s1).reverse();
            s2 =sb.toString();
            try {
                result = Integer.valueOf(s2);
                return result;
            }catch (Exception e){
                return 0;
            }
        }else {
            m = -m;
            String s1 = "" + m;
            StringBuilder sb = new StringBuilder(s1).reverse();
            s2 =sb.toString();
            try {
                result = Integer.valueOf(s2);
                return -result;
            }catch (Exception e){
                return 0;
            }
        }

        //下面就把s2给他转换成整数，如果报错就返回0
    }
}
