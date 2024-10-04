package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.dao.CustomerDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Customer;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDto customerDto) {

    }
}
