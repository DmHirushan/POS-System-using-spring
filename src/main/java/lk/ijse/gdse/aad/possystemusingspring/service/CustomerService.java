package lk.ijse.gdse.aad.possystemusingspring.service;

import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    public void saveCustomer(CustomerDto customerDto);
}
