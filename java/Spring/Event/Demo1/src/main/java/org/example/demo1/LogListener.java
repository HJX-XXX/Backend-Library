package org.example.demo1;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 日志监听器：使用 @Order 注解调整执行顺序
 * @Order(1)：数字越小，优先级越高，越先执行
 */
@Component
public class LogListener {

    @EventListener
    @Order(1)// 优先级最高，第一个执行
    public void recordLog(UserRegisterEvent event) {
        // 模拟记录日志的业务逻辑
        System.out.println("我是order 1");
        System.out.println("【日志监听器】收到用户注册事件，开始记录日志...");

    }

    @EventListener
    @Order(2)
    public void recordLog2(UserRegisterEvent event) {
        System.out.println("我是order 2");
        System.out.println("【日志监听器】注册用户：" + event.getUsername());
        System.out.println("【日志监听器】注册时间：" + event.getTimestamp());
        System.out.println("【日志监听器】日志记录成功！\n");
    }
}
