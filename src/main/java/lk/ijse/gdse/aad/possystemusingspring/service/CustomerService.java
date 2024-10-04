package lk.ijse.gdse.aad.possystemusingspring.service;

import lk.ijse.gdse.aad.possystemusingspring.customObj.CustomerResponse;
import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDto customerDto);
    public CustomerResponse getCustomer(String customerId);
    public List<CustomerDto> getAllCustomers();
    public void updateCustomer(String customerId, CustomerDto customerDto);
    public void deleteCustomer(String customerId);
}
