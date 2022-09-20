package mx.com.axity.persistence;

import mx.com.axity.model.OrderDO;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<OrderDO, Long> {
    OrderDO findByOrderId(Long orderId);
}
