package DuoThread;

/**
 * ClassName:InterAndStop
 * Description:
 *
 * @Create:2023/6/7 -22:34
 */
public class InterAndStop {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable2());
        t.setName("t");
        t.start();
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ready to interrupt!");
        // 终断t线程的睡眠（这种终断睡眠的方式依靠了java的异常处理机制。）
        //t.interrupt();
        t.stop(); //强行终止线程，这样的话，线程当中的--->end就不会被打印出来
        //缺点:容易损坏数据  线程没有保存的数据容易丢失
    }
}
class MyRunnable2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---> begin");
        try {
            // 睡眠1年
            Thread.sleep(1000 * 60 * 60 * 24 * 365);
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println("By handle the error !");
        }
        //1年之后才会执行这里
        System.out.println(Thread.currentThread().getName() + "---> end");

    }
}
