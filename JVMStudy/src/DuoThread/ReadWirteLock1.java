package DuoThread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ClassName:ReadWirteLock1
 * Description: 简单的读写锁测试，如果用synchronized方法(普通的lock方法效果类似)来保证读写的话，那么就会使得，写，写结束，写，写结束，读，读结束。。。。而且读写会穿插进行。
 * 而使用读写锁的话，写的过程是不会出现读的，而且读的时候是线程并行完成的。
 *
 * @Create:2023/6/12 -22:11
 */
public class ReadWirteLock1 {
    public static void main(String[] args) {
        Mycache1 mycache = new Mycache1();

        for (int i = 0; i < 1; i++) {
            final int num = 1;
            new Thread(() -> {
                mycache.put(num + "", num + "");
            }, String.valueOf(i)).start();//向map中插入数据
        }


        for (int i = 0; i < 5; i++) {
            final int num = 1;
            new Thread(() -> {
                mycache.get(num + "");
            }, String.valueOf(i)).start();//从map里面取数据的
        }



    }

}

//资源类
class Mycache1 {
    //在资源类当中 ，创建读写锁的对象
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Lock relock = new ReentrantLock();
    //一个map集合，
    private volatile Map<String, Object> map = new HashMap();//这个地方用不用volatile似乎都可以

    public void put(String key, Object val) {//lock和lock1是同一把锁，通过print方法可以发现，他们是相同的地址
        Lock lock = rwLock.writeLock();
//        //System.out.println(lock);
        lock.lock();//等会测试一下是不是同一把锁
//        relock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is writing data....");
            Thread.sleep(3000);
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + " is wirten Over! ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            rwLock.writeLock().unlock();
            //System.out.println(lock1);
//            relock.unlock();


        }
    }


    public Object get(String key) {
        //添加读锁
        rwLock.readLock().lock();
//        relock.lock();

        try {
            Object result = null;
            System.out.println(Thread.currentThread().getName() + " is getting data....");
            Thread.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " is getting Over !");
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            rwLock.readLock().unlock();
//            relock.unlock();

        }
    }


}
