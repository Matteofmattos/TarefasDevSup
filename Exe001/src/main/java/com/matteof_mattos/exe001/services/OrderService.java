package com.matteof_mattos.exe001.services;

import com.matteof_mattos.exe001.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public Double total(Order order) {
        int shipment = shippingService.shipment(order.getBasic());
        return (order.getBasic()-(order.getBasic()* order.getDiscount()/100)+shipment);
    }
}
