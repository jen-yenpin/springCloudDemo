package net.xdclass.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.xdclass.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @HystrixCommand(fallbackMethod = "saveOrderFail")
    @RequestMapping("save")
    public Object save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId) throws IOException {
        Map<Object, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", productOrderService.save(userId, productId));
        return data;
    }


    /* 注意，方法签名一定要要和api方法一致 */
    public Map<String, Object> saveOrderFail(int useid, int productId) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了，稍等重试");
        return msg;

    }
}

