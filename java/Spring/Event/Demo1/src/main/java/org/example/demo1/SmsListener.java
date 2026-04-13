package org.example.demo1;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 短信监听器：使用 @EventListener 注解
 */
@Component
public class SmsListener {

    /**
     * @EventListener 标注的方法就是监听器方法
     * 方法参数类型就是监听的事件类型：UserRegisterEvent
     * 只有当事件的 username 属性等于 'admin' 时，才执行这个监听器
     */
    @EventListener(condition = "#event.username == 'admin'")
    public void sendSms(UserRegisterEvent event) {
        // 模拟发送短信的业务逻辑
        System.out.println("【短信监听器】收到用户注册事件，开始发送短信...");
        System.out.println("【短信监听器】收件人手机号：" + event.getPhone());
        System.out.println("【短信监听器】短信内容：尊敬的 " + event.getUsername() + "，您已成功注册！");
        System.out.println("【短信监听器】短信发送成功！\n");
    }
}
