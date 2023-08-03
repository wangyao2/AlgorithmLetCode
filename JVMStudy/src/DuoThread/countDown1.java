package DuoThread;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName:countDown1
 * Description:演示，6个同学离开教室之后，班长关门操作
 *
 * @Create:2023/6/6 -11:33
 */
public class countDown1 {

    public static void main(String[] args) throws InterruptedException {
        //6个同学陆续离开教室，谁先谁后是不一定，时间是不确定的，用6个线程来模拟

        //设置计数的初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "go out the room!");
                countDownLatch.countDown();

            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "lock the door!");
    }

}
