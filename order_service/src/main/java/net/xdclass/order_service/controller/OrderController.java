package net.xdclass.order_service.controller;

import net.xdclass.order_service.domain.ProductOrder;
import net.xdclass.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @RequestMapping("save")
    public ProductOrder save(@RequestParam("user_id") int userId, @RequestParam("product_id") int productId) {
        try {
            return productOrderService.save(userId, productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

