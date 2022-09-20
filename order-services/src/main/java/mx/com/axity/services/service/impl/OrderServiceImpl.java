package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.ComputerTO;
import mx.com.axity.commons.to.OrderTO;
import mx.com.axity.commons.to.ResponseTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.ComputerDO;
import mx.com.axity.model.OrderDO;

import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.ComputerDAO;
import mx.com.axity.persistence.OrderDAO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    static final Logger LOG = LogManager.getLogger(OrderServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ComputerDAO computerDAO;

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserTO getUserById(int id) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDO userDo = userDAO.findById(id);
        UserTO returnValue = modelMapper.map(userDo, UserTO.class);
        return returnValue;
    }

    @Override
    public List<UserTO> getUsers() {

        LOG.info("Consultando usuarios");
        List<UserDO> usersDO =(List<UserDO>) userDAO.findAll();
        Type userDAOType = new TypeToken<List<UserDO>>() {}.getType();
        List<UserTO> usersTO = this.modelMapper.map(usersDO, userDAOType);
        LOG.info("Se retornan {} elementos", usersTO.size());
        return usersTO;
    }

    @Override
    public ResponseTO addUser(UserTO user) {
        ResponseTO responseValue = new ResponseTO();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDO userDO = modelMapper.map(user, UserDO.class);
        userDAO.save(userDO);
        responseValue.setCode(201);
        responseValue.setMessage("La persona se ha registrado con exito");
        return responseValue;
    }

    @Override
    public List<OrderTO> getOrders() {
        LOG.info("Consultando orders");
        List<OrderDO> ordersDO =(List<OrderDO>) orderDAO.findAll();
        Type orderDAOType = new TypeToken<List<OrderDO>>() {}.getType();
        List<OrderTO> ordersTO = this.modelMapper.map(ordersDO, orderDAOType);
        LOG.info("Se retornan {} elementos", ordersTO.size());
        return ordersTO;
    }

    @Override
    public OrderTO getOrderById(long orderId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDO orderDO = orderDAO.findByOrderId(orderId);
        OrderTO orderTO = new OrderTO();
        orderTO.setOrderId(orderId);
        orderTO.setDateOrder(orderDO.getDateOrder());
        List<ComputerDO> computerDO = computerDAO.findByOrderId((int)orderId);
        List<ComputerTO> computerTO = new ArrayList<>();
        for (int i=0;i<computerDO.size();i++){
            computerTO.add(modelMapper.map(computerDO.get(i), ComputerTO.class));
        }
        orderTO.setComputers(computerTO);
        return orderTO;
    }

    @Override
    public ResponseTO addComputer(ComputerTO computer) {
        ResponseTO responseValue = new ResponseTO();

        int units;
        units=(computerDAO.findByOrderId(computer.getOrderId())).size();
        if (units>=5){
            responseValue.setCode(400);
            responseValue.setMessage("Una orden no puede contener mas de 5 computadoras");
            return responseValue;
        }

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ComputerDO computerDO = modelMapper.map(computer, ComputerDO.class);
        computerDAO.save(computerDO);
        responseValue.setCode(201);
        responseValue.setMessage("La computadora se ha registrado");
        return responseValue;
    }

    @Override
    public ResponseTO addOrder(OrderTO order) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderDO orderDO = new OrderDO();
        orderDO.setDateOrder(order.getDateOrder());
        List<ComputerTO> computers = order.getComputers();
        ResponseTO responseValue = new ResponseTO();
        ComputerDO computerDO = new ComputerDO();
        orderDAO.save(orderDO);
        for (int i=0;i<computers.size();i++){
            computerDO = modelMapper.map(computers.get(i), ComputerDO.class);
            computerDO.setOrderId(Math.toIntExact(orderDO.getOrderId()));
            computerDAO.save(computerDO);
        }
        responseValue.setCode(200);
        responseValue.setMessage("Orden guardada");
        return responseValue;
    }
}
