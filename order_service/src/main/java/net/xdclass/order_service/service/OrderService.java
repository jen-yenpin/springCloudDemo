package net.xdclass.order_service.service;

import java.util.Date;
import java.util.UUID;

import net.xdclass.order_service.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    public Order save(int userId, int productId) {
        Object object = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Object.class);
        System.out.println(object);
        Order order = new Order();
        order.setTradeNo(UUID.randomUUID().toString());
        order.setCreateTime(new Date());
        order.setUserId(userId);
        return order;
    }
}
