import java.util.concurrent.*;

public class juc {
    static void main() {
        // 实现runnable接口，简化写法
        Thread thread1 = new Thread(() -> {
            System.out.println("线程执行中");
        });
        thread1.start();

        // 实现Callable接口，简化写法，可抛异常，() -> { ... } 就是 Callable 的 Lambda 简化形式
        FutureTask<Integer> task = new FutureTask<>(() -> {
            return 100;
        });
        new Thread(task).start();
        try {
            Integer result = task.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        // 使用线程池，线程能复用
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> System.out.println("任务执行"));

        // 底层默认用ForkJoinPool，方便组合多个异步任务
        CompletableFuture.runAsync(() -> System.out.println("异步执行"));

        // Java21虚拟线程，少数OS线程调度多个虚拟线程
        Thread.startVirtualThread(() -> {
            System.out.println("虚拟线程");
        });

        // 或者用虚拟线程的 ExecutorService
        try (var executor1 = Executors.newVirtualThreadPerTaskExecutor()) {
            executor1.submit(() -> System.out.println("任务"));
        }

    }
}
