package lk.ijse.gdse.aad.possystemusingspring.util;

import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import lk.ijse.gdse.aad.possystemusingspring.dto.ItemDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Customer;
import lk.ijse.gdse.aad.possystemusingspring.entity.Item;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public List<CustomerDto> convertToDtos(List<Customer> customerList){
        return modelMapper.map(customerList, new TypeToken<List<CustomerDto>>(){}.getType());
    }

    public Item convertToEntity(ItemDto itemDto){
        return modelMapper.map(itemDto, Item.class);
    }
}
