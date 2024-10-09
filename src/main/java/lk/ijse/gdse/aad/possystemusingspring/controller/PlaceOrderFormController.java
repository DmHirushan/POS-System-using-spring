package lk.ijse.gdse.aad.possystemusingspring.controller;

import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDetailDto;
import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDto;

import lk.ijse.gdse.aad.possystemusingspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/placeorder")
public class PlaceOrderFormController {
    @Autowired
    private OrderService orderService;

//    @Autowired
//    private OrderDetailService orderDetailService;

    @PostMapping(value = "order")
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @PostMapping(value = "order_detail")
//    public ResponseEntity<Void> saveOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
//        orderDetailService.saveOrderDetails(orderDetailDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
