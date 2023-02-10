package Tool.EasyThreadPool;

/**
 * @author Justice_wby
 * @create 2023-02-03 2:40
 */
/**
 * 支持 import Java 标准库 (JDK 1.8)
 */
import java.util.Date;
import java.util.concurrent.*;

/**
 * 线程池小工具：动态线程池。
 * 介绍：我们都知道线程池需要初始化，那么初始化多大的数量最好呢，业务扩展后不够用了怎么办？我定义了一个简易的动态线程池，供大家参考。
 * 通过轮训方式不断调用监听方法，获取被监听线程池的实际情况，判断当前数据跟设定阈值的关系，从而实现动态的调整线程数。
 */
public class Main {

    /**
     * 全局线程池守护线程
     *
     * @return
     * @Date 2022/12/15 18:22
     * @Author wjbgn
     **/
    static class DaemonThreadTask {

        /**
         * 服务支持最大线程数
         */
        public final static int SERVER_MAX_SIZE = 50;

        /**
         * 最大阈值Maximum threshold，百分比
         */
        private final static int MAXIMUM_THRESHOLD = 8;

        /**
         * 每次递增最大线程数
         */
        private final static int INCREMENTAL_MAX_NUM = 10;

        /**
         * 每次递增核心线程数
         */
        private final static int INCREMENTAL_CORE_NUM = 5;

        /**
         * 当前线程数
         */
        private static int currentSize = GlobalThreadPool.MAX_NUM_POOL_SIZE;

        /**
         * 当前核心线程数
         */
        private static int currentCoreSize = GlobalThreadPool.CORE_POOL_SIZE;

        /**
         * 定时任务，设置监控时间，此处使用main方法模拟
         *
         * @return
         * @Date 2022/12/15 18:21
         * @Author wjbgn
         **/
//        @Scheduled(cron = "0 */5 * * * ?")
//        public static void execute() {
//            threadMonitor();
//        }


        /**
         * 动态监控并设置线程参数
         *
         * @return int
         * @Param
         * @Date 2022/12/15 18:20
         * @Author wjbgn
         **/
        public static int threadMonitor() {
            ThreadPoolExecutor instance = GlobalThreadPool.getExecutor();
            int activeCount = instance.getActiveCount();
            int size = instance.getQueue().size();
            System.out.println("GlobalThreadPool: the active thread count is " + activeCount);
            // 线程数不足，增加线程
            if (activeCount > GlobalThreadPool.MAX_NUM_POOL_SIZE % MAXIMUM_THRESHOLD
                    && size >= GlobalThreadPool.BLOCKING_QUEUE_SIZE) {
                currentSize = currentSize + INCREMENTAL_MAX_NUM;
                currentCoreSize = currentCoreSize + INCREMENTAL_CORE_NUM;
                //当前设置最大线程数小于服务最大支持线程数才可以继续增加线程
                if (currentSize <= SERVER_MAX_SIZE) {
                    instance.setCorePoolSize(currentCoreSize);
                    instance.setMaximumPoolSize(currentSize);
                    System.out.println("this max thread size is " + currentSize);
                } else {
                    System.out.println("current size is more than server max size, can not add");
                }
            }
            // 线程数足够，降低线程数，当前活跃数小于默认核心线程数
            if (activeCount < GlobalThreadPool.MAX_NUM_POOL_SIZE
                    && size == 0
                    && currentSize > GlobalThreadPool.MAX_NUM_POOL_SIZE) {
                currentSize = GlobalThreadPool.MAX_NUM_POOL_SIZE;
                currentCoreSize = GlobalThreadPool.CORE_POOL_SIZE;
                instance.setCorePoolSize(currentCoreSize);
                instance.setMaximumPoolSize(currentSize);
            }
            return activeCount;
        }
    }

    /**
     * 全局通用线程池
     */
    static class GlobalThreadPool {

        /**
         * 核心线程数
         */
        public final static int CORE_POOL_SIZE = 5;

        /**
         * 最大线程数
         */
        public final static int MAX_NUM_POOL_SIZE = 10;

        /**
         * 任务队列大小
         */
        public final static int BLOCKING_QUEUE_SIZE = 10;

        /**
         * 线程池实例
         */
        private final static ThreadPoolExecutor instance = getInstance();


        /***
         * 初始化线程池
         *
         * @Param
         * @return java.util.concurrent.ThreadPoolExecutor
         * @Date 2022/12/15 18:19
         * @Author wjbgn
         **/
        private synchronized static ThreadPoolExecutor getInstance() {
            // 生成线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    CORE_POOL_SIZE,
                    MAX_NUM_POOL_SIZE,
                    60,
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(BLOCKING_QUEUE_SIZE));
            return executor;
        }

        private GlobalThreadPool() {
        }

        public static ThreadPoolExecutor getExecutor() {
            return instance;
        }
    }

    /**
     * 测试方法
     * <p>
     * 默认20个线程，超过当前线程池范围，监控到会进行扩容，当处理完成后，线程池会进行缩容
     *
     * @return void
     * @Param args
     * @Date 2022/12/15 18:19
     * @Author wjbgn
     **/
    public static void main(String[] args) throws InterruptedException {
        // 创建20个任务，每个任务阻塞100豪秒
        for (int i = 0; i < 20; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(new Date() + ":" + Thread.currentThread().getName());
            }, GlobalThreadPool.getExecutor());
        }
        // 每10豪秒监听一次
        System.out.println("START >>>>");
        for (; ; ) {
            int activeCount = DaemonThreadTask.threadMonitor();
            Thread.sleep(10);
            if (activeCount == 0) {
                break;
            }
        }
        GlobalThreadPool.getExecutor().shutdown();
        System.out.println("END  >>>>");
    }
}



