package net.xdclass.order_service.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单实体类
 */
@Data
public class Order implements Serializable {


    private int id;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 订单号
     */
    private String tradeNo;

    /**
     * 价格,分
     */
    private int price;


    private Date createTime;


    private int userId;

    private String userName;
}
