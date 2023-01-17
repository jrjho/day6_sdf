package day6_lecture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run(){

                for (int i = 0; i< 5; i++)
                    System.out.println(Thread.currentThread().getName() + 
                    "\t Runnable ..." + i);
            }
        });
        //execute using thread
        // thread1.start();

        MyRunnableImplementation mRI = new MyRunnableImplementation("task1");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("task2");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("task3");
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("task4");
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("task5");

        // Thread thread2 = new Thread(mRI);
        // thread2.start();

        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        //execute using single thread pool
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute(mRI);
        // executorService.execute(mRI2);

        // executorService.shutdown();

        //execute using multiple thread pool. 
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.execute(mRI4);
        // executorService.execute(mRI5);
        // executorService.shutdown();

        //depends on number of threads available on computer
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.execute(mRI4);
        // executorService.execute(mRI5);
        // executorService.shutdown();

        MyRunnableInterface<String> concatenateString = (a,b) -> {
            return a+b;
        };
        System.out.println("addOperation" + concatenateString.process("씨발", " 년!"));
        
        MyRunnableInterface<Integer> multiplyOperation = (a,b) -> {
            return a*b;
        };
        System.out.println("MutiplyOperation: " + multiplyOperation.process(29,45));
        
        MyRunnableInterface<Integer> minusOperation = (a,b) -> {
            return a-b;
        };
        System.out.println("minusOperation: " + minusOperation.process(29,45));

    }

}
