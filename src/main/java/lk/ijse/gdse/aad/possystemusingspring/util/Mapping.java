package lk.ijse.gdse.aad.possystemusingspring.util;

import lk.ijse.gdse.aad.possystemusingspring.customObj.CustomerResponse;
import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public Customer convertToEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }

    public CustomerDto convertToDto(Customer customer){
        return modelMapper.map(customer, CustomerDto.class);
    }

}
