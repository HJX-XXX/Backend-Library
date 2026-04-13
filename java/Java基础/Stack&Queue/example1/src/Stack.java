import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
    static void main() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
    }

}
