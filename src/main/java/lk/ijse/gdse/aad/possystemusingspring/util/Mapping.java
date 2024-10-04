package lk.ijse.gdse.aad.possystemusingspring.util;

import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    private ModelMapper modelMapper;

    public Customer convertToEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }
}
