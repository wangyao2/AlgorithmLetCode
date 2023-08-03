package DuoThread;

import java.awt.image.LookupOp;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName:ShunXvThread
 * Description:让线程按照指定的顺序执行
 *  AA线程打印5次，BB线程打印10次，CC打印15次
 *  进行10论操作，让线程定制化的执行。
 *  难点是如何按照指定的顺序执行
 * @Create:2023/6/4 -16:40
 */
public class ShunXvThread {

    public static void main(String[] args) {
        Share3 share3 = new Share3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share3.print5(i);
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share3.print10(i);
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                share3.print2(i);
            }
        },"CC").start();

    }
}
class Share3{
    //定义标志位，通过标志位来操作
    private int flag = 1;
    //创建lock锁
    private Lock lock = new ReentrantLock();
    //创建3个条件
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(int loop){
        lock.lock();
        try{
            while (flag != 1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " :: print times: " + i +"lunci"
                + loop);
            }
            flag =2;
            c2.signal();//通知BB线程
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loop){
        lock.lock();
        try{
            while (flag != 2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " :: print times: " + i +"lunci"
                        + loop);
            }
            flag =3;
            c3.signal();//通知cc线程
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void print2(int loop){
        lock.lock();
        try{
            while (flag != 3){
                c3.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " :: print times: " + i +"lunci"
                        + loop);
            }
            flag =1;
            c1.signal();//通知BB线程
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
