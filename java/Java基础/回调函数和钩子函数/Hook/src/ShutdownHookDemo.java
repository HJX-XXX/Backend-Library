public class ShutdownHookDemo {
    static void main() {
        // 注册 JVM 关闭钩子：Runtime.getRuntime().addShutdownHook(Thread)
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // 这就是钩子函数：JVM 关闭前会自动执行这里的代码
            System.out.println("【钩子函数】JVM 要关闭了，我要清理资源：关闭数据库连接、保存临时数据...");
        }));

        System.out.println("主程序：开始运行...");
        // 模拟主程序执行 3 秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主程序：运行结束，准备退出...");
    }
}
