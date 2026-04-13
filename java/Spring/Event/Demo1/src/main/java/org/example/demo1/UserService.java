package org.example.demo1;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 注入事件发布者：Spring 会自动注入 ApplicationContext（它实现了 ApplicationEventPublisher）
    private final ApplicationEventPublisher eventPublisher;

    // 构造器注入（推荐）
    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void register(String username, String email, String phone) {
        // 1. 主业务逻辑：模拟写入数据库
        System.out.println("【用户服务】开始执行用户注册主业务...");
        System.out.println("【用户服务】写入数据库：username=" + username + ", email=" + email + ", phone=" + phone);
        System.out.println("【用户服务】用户注册主业务执行成功！\n");

        // 2. 发布事件：解耦副业务
        // 创建用户注册事件，传入 this（事件源是当前 UserService）和业务数据
        UserRegisterEvent event = new UserRegisterEvent(this, username, email, phone);
        // 发布事件
        eventPublisher.publishEvent(event);

        System.out.println("【用户服务】事件发布完成，主业务继续执行其他逻辑（如果有）...");
    }

}
