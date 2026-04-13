public class Calculator {
    // 定义计算器类
    public void add(int a, int b, Callback callback) {
        System.out.println("a=" + a + "b=" + b + "result =" + (a + b));
        int result = a + b;
        // 关键！调用回调函数 把结果传回给对方
        callback.onResult(result);
    }
}
