package DuoThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ClassName:BlockQuee
 * Description: 练习阻塞队列用的
 *
 * @Create:2023/6/13 -23:28
 */
public class BlockQuee {
    public static void main(String[] args) {
        //创建阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));


    }
}
