package DuoThread;

import sun.applet.Main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName:FutureTest
 * Description:
 *
 * @Create:2023/6/6 -11:09
 */
public class FutureTest {
    public static void main(String[] args) {

        FutureTask<Integer> futruetaask1 = new FutureTask<>(new Mythresd1());
        FutureTask<Integer> futruetaask2 = new FutureTask<>(()-> {
            System.out.println(Thread.currentThread().getName() + "comin task2");
            return 1024;
        });
        //FutureTask是实现了runnable接口的还有
        new Thread(futruetaask1,"jack").start();
        new Thread(futruetaask2,"lucy").start();


        try {
//            while (!futruetaask2.isDone()){
//                System.out.println("task in not done, waiting....");
//            }

            System.out.println(futruetaask2.get());
            Integer inter2 = futruetaask2.get();

            System.out.println(futruetaask1.get());
            Integer inter1 = futruetaask1.get();


            System.out.println(futruetaask2.get());//主线程会去等待task1的结果

            System.out.println(inter1+inter2);
            System.out.println(Thread.currentThread().getName() + "come over  ");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
class Mythresd1 implements Callable{
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "comin task1");
        Thread.sleep(2000);
        return 200;
    }
}
class Mythresd3 implements Runnable{
    @Override
    public void run() {

    }
}