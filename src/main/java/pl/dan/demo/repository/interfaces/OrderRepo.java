package pl.dan.demo.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import pl.dan.demo.model.Order;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

}
