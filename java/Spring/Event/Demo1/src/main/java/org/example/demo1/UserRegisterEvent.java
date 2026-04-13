package org.example.demo1;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件：继承 ApplicationEvent
 */
public class UserRegisterEvent extends ApplicationEvent {
    // 业务数据：用户名
    private final String username;
    // 业务数据：邮箱
    private final String email;
    // 业务数据：手机号
    private final String phone;

    /**
     * 构造器
     * @param source 事件发布源（通常是发布事件的 Service 或 Controller）
     * @param username 用户名
     * @param email 邮箱
     * @param phone 手机号
     */
    public UserRegisterEvent(Object source, String username, String email, String phone) {
        super(source);
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    // Getter 方法（监听器需要通过这些方法获取业务数据）
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
