package org.example.aop;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("保存订单， orderId：" + saveOrder.getId());
        return true;
    }

    @RecordOperate(desc = "更新订单", convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("更新订单，orderId：" + updateOrder.getOrderId());
        return true;
    }

}
