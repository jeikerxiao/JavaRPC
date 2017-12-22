package com.jeiker.rpc.demo.client;

import com.jeiker.rpc.client.RpcProxy;
import com.jeiker.rpc.demo.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池
 */
public class HelloClient4 {

    private static final Logger logger = LoggerFactory.getLogger(HelloClient4.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        final RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        int threadNum = 10;
        int loopCount = 100;

        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        final CountDownLatch latch = new CountDownLatch(loopCount);

        try {
            long start = System.currentTimeMillis();

            for (int i = 0; i < loopCount; i++) {
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        HelloService helloService = rpcProxy.create(HelloService.class);
                        String result = helloService.hello("World");
                        logger.info(result);
                        latch.countDown();
                    }
                });
            }
            latch.await();

            long time = System.currentTimeMillis() - start;
            logger.info("thread: " + threadNum);
            logger.info("loop: " + loopCount);
            logger.info("time: " + time + "ms");
            logger.info("tps: " + (double) loopCount / ((double) time / 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

        System.exit(0);
    }
}
