package DuoThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:LsaleTichke
 * Description:
 *
 * @Create:2023/6/4 -15:02
 */
public class LsaleTichke {
    public static void main(String[] args) {
        LTicked ticked = new LTicked();
//        new Thread(()->{
//            for (int i =0;i < 40;i++){
//                ticked.sale();
//            }
//        },"AA").start();
        new Thread(ticked, "AA").start();
        new Thread(ticked, "BB").start();
        new Thread(ticked, "CC").start();

    }
}

class LTicked implements Runnable {
    private int number = 30;
    //创建可重入锁
    private final ReentrantLock lock = new ReentrantLock();

    public  void run() {
        //每个线程，操作数量的时候，先上锁
        lock.lock();
        try {
            for (int i = 0; i < 40; i++) {
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + " SaleOut:  " + number-- + " Remainning: " + number);
                    Thread.sleep(100);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }

}
