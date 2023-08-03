package DuoThread;

/**
 * ClassName:DeadLock
 * Description:两个以上的进程，因为互相争夺资源，而造成互相等待的现象。
 * 如果没有外力的干涉，那么就没法再进行下去了
 *
 * @Create:2023/6/5 -21:59
 */
public class DeadLock {

    //创建两个对象
    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {
        //产生死锁的原因，系统资源不足；进程推进的顺序不合理；资源分配不当
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"We hold a A lock, and try to get lock B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"We get the lock B success");

                }
            }
        },"aa").start();


        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"We hold a B lock, and try to get lock A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"We get the lock A success");

                }
            }
        },"bbb").start();
    }
}
