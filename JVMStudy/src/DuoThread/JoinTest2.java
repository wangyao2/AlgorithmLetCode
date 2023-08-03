package DuoThread;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:JoinTest2
 * Description:
 *
 * @Create:2023/6/8 -11:20
 */
public class JoinTest2 {
    public static void main(String[] args) {
        // 获取主线程
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 在子线程中，让主线程中断
                    System.out.println("thread1已启动,在thread1的run方法中，让主线程中断停止了");
                    //mainThread.interrupt();
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("thread1的run方法运行结束");
                } catch (InterruptedException e) {
                    System.out.println("子线程开始响应中断，抛出中断异常说明成功中断");
                }
            }
        }, "thread1");
        thread1.start();
        try {
            // 主线程在等待子线程执行结束后，再执行后续代码。如果主线程在等待时被打断，那thread1.join()会抛出异常，
            // 此时正确的做法是在catch语句中将中断传递给thread1,让thread1也中断，保证多个线程执行的一致性；
            // 若不手动终止thread1，则thread1会继续执行，可能会造成一些数据同步上的问题。
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("主线程执行thread.join()方法时出现异常,提示主线程中断了（验证线程名：" + Thread.currentThread().getName() + ")");
            e.printStackTrace();
            thread1.interrupt();
        }
        System.out.println("main方法全部运行完毕");
    }
}
