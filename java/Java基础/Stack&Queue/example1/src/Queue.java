import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Queue {
    static void main() {
        java.util.Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.poll();
    }
}
