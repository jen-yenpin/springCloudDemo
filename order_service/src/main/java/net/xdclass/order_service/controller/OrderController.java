package net.xdclass.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jdk.nashorn.internal.ir.RuntimeNode;
import net.xdclass.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public Object save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId, HttpServletRequest request) throws IOException {
        String cookie = request.getHeader("cookie");
        String token = request.getHeader("token");
        System.out.println(cookie);
        System.out.println(token);
        Map<Object, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", productOrderService.save(userId, productId));
        return data;
    }


    /* 注意，方法签名一定要要和api方法一致 */
    public Map<String, Object> saveOrderFail(int useid, int productId, HttpServletRequest request) {
        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购人数太多，您被挤出来了，稍等重试");
        return msg;

    }
}

