package DuoThread;

import sun.security.provider.SHA;

/**
 * ClassName:ThreadDemo1Communicate
 * Description: 两个线程按照先后顺序操作一个变量，使用synchronized来实现。当然也可以用lock来实现
 *
 * @Create:2023/6/4 -15:33
 */

class Share {
    //来一个资源类
    private int number = 0;

    public synchronized void incr() throws InterruptedException {
        //判断， 干活 ， 通知
        while (number == 1) {
            System.out.println(Thread.currentThread().getName() + " :: is waiting!");
            this.wait();
        }

        number++;
        System.out.println(Thread.currentThread().getName() + " :: " + number + " plus 1");
        this.notifyAll();

    }

    public synchronized void decr() throws InterruptedException {
        while (number == 0) {
            //值不是1，也就是0的话，那么线程九等待
            System.out.println(Thread.currentThread().getName() + " :: is waiting!");
            this.wait();

        }

        //如果值是1 的话，那么线程就干活
        number--;
        System.out.println(Thread.currentThread().getName() + " :: " + number + " decrease 1");
        this.notifyAll();

    }
}

public class ThreadDemo1Communicate {

    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "+AA+1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "-BB-1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "+CC+1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "-DD-1").start();

    }
}
