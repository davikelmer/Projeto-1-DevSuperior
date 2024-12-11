package com.devsuperior.Projeto_1.service;

import com.devsuperior.Projeto_1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private DiscountService discountService;
    @Autowired
    private ShippingService shippingService;

    public OrderService(DiscountService discountService, ShippingService shippingService) {
        this.discountService = discountService;
        this.shippingService = shippingService;
    }

    public double total(Order order) {
        return discountService.priceWithDiscount(order) + shippingService.Shipping(order);

    }
}
