package DuoThread;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:WaitAndNotify
 * Description:
 *
 * @Create:2023/6/8 -10:41
 */
public class WaitAndNotify {

    public static Object object = new Object();
    // Thread0线程，执行wait()方法
    static class Thread0 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "初次获得对象锁，执行中，调用共享对象的wait()方法...");
                try {
                    // 共享对象wait方法，会让线程释放锁。
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "再次获得对象锁，执行结束");
            }
        }
    }

    // Thread1线程，执行notify()方法
    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                // 线程共享对象，通过notify()方法，释放锁并通知其他线程可以得到锁
                //object.notify();
                System.out.println(Thread.currentThread().getName() + "获得对象锁，执行中，调用了共享对象的notify()方法");
            }
        }
    }

    // 主线程
    public static void main(String[] args) {
        Thread0 thread0 = new Thread0();
        Thread1 thread1 = new Thread1();
        thread0.start();
        thread1.start();

        try {
            Thread.sleep(10);
            // 保证线程Thread0中的wait()方法优先执行，再执线程Thread1的notify()方法
            System.out.println(Thread.currentThread().getName() + "running ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
