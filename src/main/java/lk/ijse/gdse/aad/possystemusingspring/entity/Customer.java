package lk.ijse.gdse.aad.possystemusingspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
