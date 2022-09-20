package mx.com.axity.services.service;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrderTO;
import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.commons.to.UserTO;
import java.util.List;

public interface IOrderService {

    UserTO getUserById(int id);
    List<UserTO> getUsers();
    ResponseTO addUser(UserTO user);
    List<OrderTO> getOrders();
    OrderTO getOrderById(long orderId);
    ResponseTO addComputer(ComputerTO computer);
    ResponseTO addOrder(OrderTO order);
}
