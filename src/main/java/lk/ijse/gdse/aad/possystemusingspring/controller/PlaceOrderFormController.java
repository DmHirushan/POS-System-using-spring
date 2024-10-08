package lk.ijse.gdse.aad.possystemusingspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/placeorder")
public class PlaceOrderFormController {
    @GetMapping
    public String healthCheck(){
        return "Place Order up and running!";
    }
}
