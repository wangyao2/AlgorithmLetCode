package OtherStudy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class HanMingDistance {

    public static void main(String[] args) {

        //String s = Integer.toBinaryString(126);
        //System.out.println(s);

        int i = hammingDistance(0, 0);
        System.out.println(i);
    }

    public static int hammingDistance(int x, int y) {
        int chazhi = 0;
        String xstring;
        String ystring;
        if (x>y){
            xstring = Integer.toBinaryString(x);
            ystring = Integer.toBinaryString(y);
        }else {
            xstring = Integer.toBinaryString(y);
            ystring = Integer.toBinaryString(x);
        }

        char[] xchars = xstring.toCharArray();
        char[] ychars = ystring.toCharArray();

        char[] midCharrs = new char[xchars.length];

        int i = 0;
        for (; i < ychars.length; i++) {//这个for循环进行填充到后面去
            midCharrs[xchars.length - 1 - i] = ychars[ychars.length - 1 - i];
        }

        for (int m = 0; m <= xchars.length - 1 - i; m++) {//这个for循环进行填充前面的0值
            midCharrs[m] = '0';
        }

        for (int j = 0; j < xchars.length; j++) {//这个for循环进行判断
            if (xchars[j] != midCharrs[j]) {
                chazhi++;
            }
        }

        return chazhi;
    }
}
