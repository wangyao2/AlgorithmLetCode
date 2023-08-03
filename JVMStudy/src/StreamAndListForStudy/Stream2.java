package StreamAndListForStudy;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ClassName:Stream1
 * Description:
 *
 * @Create:2023/6/16 -22:54
 */
public class Stream2 {
    public static void main(String[] args) {

        ArrayList<String> List1 = new ArrayList();
        List1.add("张无忌");
        List1.add("周");
        List1.add("赵");
        List1.add("张强");
        List1.add("张三丰");
        List1.stream().filter(s -> s.startsWith("张")).filter(s -> s.length()==3).forEach(System.out::println);
        //List1.stream();
        HashMap<String,Integer> hm = new HashMap<>();

    }

    @Test
    public void NumFilter(){
        ArrayList<Integer> list = new ArrayList<>();
        int[] lis = {1,2,3,4,5,6,7,8,9,10};
        int[] ints = Arrays.stream(lis).filter( s -> s % 2 == 0).toArray();
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void GuolvMap(){
        ArrayList<String> names = new ArrayList<>();
        names.add("zhangsan,23");
        names.add("lsis,24");
        names.add("wangwu,25");

        Map<String, Integer> collect = names.stream().filter(s -> Integer.parseInt(s.split(",")[1]) > 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.valueOf(s.split(",")[1])));

        for (String s : collect.keySet()) {
            System.out.println(collect.get(s));
        }
    }
}
