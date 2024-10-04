package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.customObj.CustomerErrorResponse;
import lk.ijse.gdse.aad.possystemusingspring.customObj.CustomerResponse;
import lk.ijse.gdse.aad.possystemusingspring.dao.CustomerDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.CustomerDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Customer;
import lk.ijse.gdse.aad.possystemusingspring.exception.CustomerNotFoundException;
import lk.ijse.gdse.aad.possystemusingspring.exception.DataPersistFailedException;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        if (customerDao.existsById(customerDto.getCustomerId())) {
            throw new DataPersistFailedException("This customer ID already exists!");
        }else {
            Customer savedCustomer = customerDao.save(mapping.convertToEntity(customerDto));
            if (savedCustomer == null && savedCustomer.getCustomerId() == null) {
                throw new DataPersistFailedException("Can't save the customer!");
            }
        }

    }

    @Override
    public CustomerResponse getCustomer(String customerId) {
        if (customerDao.existsById(customerId)) {
            return mapping.convertToDto(customerDao.getCustomerByCustomerId(customerId));
        } else {
            return new CustomerErrorResponse(0, "Customer Not Found!");
        }

    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return mapping.convertToDtos(customerDao.findAll());
    }

    @Override
    public void updateCustomer(String customerId, CustomerDto incomeCustomerDto) {
        Optional<Customer> tmpCustomer = customerDao.findById(customerId);
        if (!tmpCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer Not Found!");
        }else {
            tmpCustomer.get().setCustomerName(incomeCustomerDto.getCustomerName());
            tmpCustomer.get().setCustomerAddress(incomeCustomerDto.getCustomerAddress());
            tmpCustomer.get().setCustomerSalary(incomeCustomerDto.getCustomerSalary());
        }
    }

    @Override
    public void deleteCustomer(String customerId) {

    }
}
