import java.util.concurrent.ForkJoinPool;

public class main {
    static void main() {
        ForkJoinPool pool = new ForkJoinPool();
        Long result = pool.invoke(new SumTask(1, 10000000));
        System.out.println(result);
    }
}
