package StreamAndListForStudy;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ClassName:Stream1
 * Description:
 *
 * @Create:2023/6/16 -22:54
 */
public class Stream1 {
    public static void main(String[] args) {

        ArrayList<String> List1 = new ArrayList();
        List1.add("张无忌");
        List1.add("周");
        List1.add("赵");
        List1.add("张强");
        List1.add("张三丰");
        ArrayList<String> List2 = new ArrayList();
        ArrayList<String> List3 = new ArrayList();

        for (String s : List1) {
            if (s.startsWith("张")){
                List2.add(s);
            }
        }
        System.out.println(List2 +"------------------");
        for (String s : List2) {
            if (s.length()==3){
                List3.add(s);
            }
        }
        System.out.println(List3 +"------------------");

    }
}
