package net.xdclass.order_service.controller;

import net.xdclass.order_service.domain.Order;
import net.xdclass.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("save")
    public Order save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId) {
        return orderService.save(userId, productId);
    }
}

