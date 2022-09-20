package mx.com.axity.services.facade;

import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.commons.to.OrderTO;
import mx.com.axity.commons.to.ComputerTO;

import java.util.List;

public interface IOrderFacade {

    UserTO getUserById(int id);
    List<UserTO> getAllUsers();

    ResponseTO addUser(UserTO user);
    List<OrderTO> getAllOrders();
    ResponseTO addComputer(ComputerTO computer);
    OrderTO getOrderById(long orderId);
    ResponseTO addOrder(OrderTO order);

}
