package org.example.demo1;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 邮件监听器：实现 ApplicationListener 接口
 * 泛型指定监听的事件类型：UserRegisterEvent
 */
@Component
public class EmailListener implements ApplicationListener<UserRegisterEvent> {

    // 标记为异步执行
    @Async
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        // 模拟耗时操作：休眠3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("【邮件监听器】（异步执行）邮件发送成功！线程名：" + Thread.currentThread().getName());
    }
}
