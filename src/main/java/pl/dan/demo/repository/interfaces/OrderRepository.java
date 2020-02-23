package pl.dan.demo.repository.interfaces;

import pl.dan.demo.model.Order;

public interface OrderRepository {

    Order save(Order order);
}
