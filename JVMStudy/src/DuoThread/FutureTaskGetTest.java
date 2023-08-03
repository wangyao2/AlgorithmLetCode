package DuoThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName:FutureTaskGetTest
 * Description:
 *
 * @Create:2023/6/7 -22:37
 */
public class FutureTaskGetTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 10000; i++) {
                    sum = sum + i;
                }
                Thread.sleep(1000);
                System.out.println("Future is done!");
                return sum;
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        Integer o = (Integer) futureTask.get();


        int summm = 0;
        for (int i = 0; i < 10; i++) {
            summm = summm + i;
        }
        System.out.println("main method get the anwer! " + summm);

        System.out.println(o);

    }
}
