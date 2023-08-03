package DuoThread;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.*;

/**
 * ClassName:ZiDingYiPool
 * Description:
 *
 * @Create:2023/6/15 -23:57
 */
public class ZiDingYiPool {
    public static void main(String[] args) {
        ///自定义线程池
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 2L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        try {
            for (int i = 0; i < 15; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "  okok");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }finally {
            threadPoolExecutor.shutdown();
        }

    }
}
