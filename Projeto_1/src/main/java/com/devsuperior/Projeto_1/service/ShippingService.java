package com.devsuperior.Projeto_1.service;

import com.devsuperior.Projeto_1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    private DiscountService discountService;

    public ShippingService(DiscountService discountService) {
        this.discountService = discountService;
    }

    public double Shipping(Order order) {
        double priceWithDiscount = discountService.priceWithDiscount(order);
        if (priceWithDiscount < 100){
            return 20.0;
        }
        else if (priceWithDiscount >= 100 && priceWithDiscount < 200){
            return 12.0;
        }
        else{
            return 0.0;
        }
    }
}
