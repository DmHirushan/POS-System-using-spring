package lk.ijse.gdse.aad.possystemusingspring.dao;

import lk.ijse.gdse.aad.possystemusingspring.entity.impl.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository <Customer, String>{
    @Query()
    Customer getCustomerByCustomerId(String customerId);
}
