import java.util.concurrent.RecursiveTask;

// 计算1到1000w的累加
public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private final long start, end;

    public SumTask(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if(end - start <= THRESHOLD) {
            // 任务足够小 直接计算
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        // 任务太大 拆成两半
        long mid = (start + end)/2;
        SumTask left = new SumTask(start, mid);
        SumTask right = new SumTask(mid+1, end);
        left.fork(); // 异步执行左半部分
        Long rightResult = right.compute();// 当前线程执行右半部分
        Long leftResult = left.join();// 等待左半部分完成
        return leftResult + rightResult;
    }
}
