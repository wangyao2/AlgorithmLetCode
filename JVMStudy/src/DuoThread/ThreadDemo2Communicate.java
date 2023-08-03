package DuoThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:ThreadDemo2Communicate
 * Description:
 *
 * @Create:2023/6/4 -16:43
 */
public class ThreadDemo2Communicate {
    public static void main(String[] args) {
        Share2 share2 = new Share2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "+AA+1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "-BB-1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "+CC+1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "-DD-1").start();

    }

}

class Share2 {
    //来一个资源类
    private int number = 0;
    private  ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void incr() throws InterruptedException {
        //判断， 干活 ， 通知
        lock.lock();
        try {
            while (number == 1) {
                System.out.println(Thread.currentThread().getName() + " :: is waiting!");
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " :: " + number + " plus 1");
            condition.notifyAll();
        }finally {
            lock.unlock();
        }

    }

    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (number == 0) {
                //值不是1，也就是0的话，那么线程九等待
                System.out.println(Thread.currentThread().getName() + " :: is waiting!");
                condition.await();

            }

            //如果值是1 的话，那么线程就干活
            number--;
            System.out.println(Thread.currentThread().getName() + " :: " + number + " decrease 1");
            condition.notifyAll();
        }finally {
            lock.unlock();
        }

    }
}
