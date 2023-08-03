package DuoThread;

/**
 * ClassName:KeChongRUsuo
 * Description:
 *
 * @Create:2023/6/5 -21:39
 */
public class KeChongRUsuo {

    public static void main(String[] args) {

        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"WaiCeng");
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"Zhongbu");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"NeiU");
                    }
                }

            }
        },"t1").start();
    }
}
