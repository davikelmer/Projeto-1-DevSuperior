package com.devsuperior.Projeto_1.service;

import com.devsuperior.Projeto_1.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public double priceWithDiscount(Order order) {
        return order.getBasic() * ((100 - order.getDiscount())/100);
    }
}
