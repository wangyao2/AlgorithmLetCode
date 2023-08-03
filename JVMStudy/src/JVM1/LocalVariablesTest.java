package JVM1;

import java.util.Date;

public class LocalVariablesTest {
    private int count = 0;
    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num;//局部变量不赋值，不会出现在局部变量表里
        test.test1();


    }

    private static void test1() {

        Date date = new Date();
        String name ="hfjlakskhdkjhk.com";
        System.out.println(name);
    }


    public static void testStatic(){
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);

    }
}
