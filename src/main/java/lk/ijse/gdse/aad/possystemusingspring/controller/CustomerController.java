package lk.ijse.gdse.aad.possystemusingspring.controller;

import lk.ijse.gdse.aad.possystemusingspring.customObj.CustomerResponse;
import lk.ijse.gdse.aad.possystemusingspring.dto.impl.CustomerDto;
import lk.ijse.gdse.aad.possystemusingspring.exception.CustomerNotFoundException;
import lk.ijse.gdse.aad.possystemusingspring.exception.DataPersistFailedException;
import lk.ijse.gdse.aad.possystemusingspring.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDto customerDto){
        if (customerDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            try {
                customerService.saveCustomer(customerDto);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }catch (DataPersistFailedException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomer(@PathVariable ("customerId") String customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable ("customerId") String customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable ("customerId") String customerId){
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
