package DuoThread;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:JoinTest
 * Description:
 *
 * @Create:2023/6/8 -11:13
 */
public class JoinTest {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " Child thread is running!");
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

//        while (thread1.isAlive() || thread2.isAlive()) {//这个while循环是join的等价写法
//            //只要两个线程中有任何一个线程还在活动，主线程就不会往下执行
//        }
        try {
            //主线程开始等待子线程thread1，thread2
            thread1.join();
            thread2.join();
            //两个join的等价写法，用isalive来代替

            //Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //等待两个线程都执行完（不活动）了，才执行下行打印
        System.out.println("Main is over!");
    }
}
