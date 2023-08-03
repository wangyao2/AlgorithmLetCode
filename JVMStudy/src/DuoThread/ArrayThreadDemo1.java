package DuoThread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ClassName:ArrayThreadDemo1
 * Description:list集合的线程安全问题
 *
 * @Create:2023/6/4 -20:07
 */
public class ArrayThreadDemo1 {

    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 20; i++) {
            //直接开10个线程
            new Thread(()->{
                //synchronized (list){
                    list.add(UUID.randomUUID().toString());
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(list);
                //}
            },String.valueOf(i)).start();
        }
    }
}
