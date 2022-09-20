package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrderTO;
import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IOrderFacade;
import mx.com.axity.services.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderFacade implements IOrderFacade {

    @Autowired
    private IOrderService orderService;

    @Override
    public UserTO getUserById(int id) {
        return this.orderService.getUserById(id);
    }

    public List<UserTO> getAllUsers() {
        return this.orderService.getUsers();
    }

    @Override
    public ResponseTO addUser(UserTO user) {
        return this.orderService.addUser(user);
    }

    @Override
    public List<OrderTO> getAllOrders() {
        return this.orderService.getOrders();
    }
    @Override
    public ResponseTO addComputer(ComputerTO computer) {
        return this.orderService.addComputer(computer);
    }

    @Override
    public OrderTO getOrderById(long orderId) {
        return this.orderService.getOrderById(orderId);
    }

    @Override
    public ResponseTO addOrder(OrderTO order) {
        return this.orderService.addOrder(order);
    }
}
