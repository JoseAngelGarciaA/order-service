package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.com.axity.commons.to.*;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IOrderFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("serviceorder/v1")
@Api(value="order")
public class OrderController {

    static final Logger LOG = LogManager.getLogger(OrderController.class);

    @Autowired
    IOrderFacade IOrderFacade;

    @GetMapping(value = "/users", produces = "application/json")
    @ApiOperation(value = "Buscar Usuarios",
            notes = "Retorna todos los usuarios",
            response = UserTO.class,
            produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        List<UserTO> users = this.IOrderFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserTO> getUser(@PathVariable("id") int id) {
        LOG.info("Se invoca GET /user/" + id);
        UserTO responseValue = new UserTO();
        responseValue = IOrderFacade.getUserById(id);
        return new ResponseEntity<UserTO>(responseValue, HttpStatus.OK);
    }

    @PostMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseTO> addUser(@RequestBody UserTO request) {
        LOG.info("Se invoca POST /user");
        ResponseTO responseValue = IOrderFacade.addUser(request);
        return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
    }

    @PostMapping(value = "/computer", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseTO> createComputer(@RequestBody ComputerTO request) {
        LOG.info("Se invoca POST /computer");
        ResponseTO responseValue = IOrderFacade.addComputer(request);
        return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<OrderTO>>getAllOrders() {
        List<OrderTO> orders = this.IOrderFacade.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/order/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<OrderTO> getOrder(@PathVariable("id") int id) {
        LOG.info("Se invoca GET /order/" + id);
        OrderTO responseValue = new OrderTO();
        responseValue = IOrderFacade.getOrderById(id);
        return new ResponseEntity<OrderTO>(responseValue, HttpStatus.OK);
    }

    @PostMapping(value = "/order", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ResponseTO> createOrder(@RequestBody OrderTO request) {
        LOG.info("Se invoca POST /order");
        ResponseTO responseValue = IOrderFacade.addOrder(request);
        return new ResponseEntity<ResponseTO>(responseValue, HttpStatus.CREATED);
    }

    @GetMapping(value = "/ping", produces = "application/json")
    @ApiOperation(value = "Ping",
            notes = "Pong",
            produces = "application/json")
    public ResponseEntity test() {
        return new ResponseEntity<>("pong", HttpStatus.OK);
    }
}
