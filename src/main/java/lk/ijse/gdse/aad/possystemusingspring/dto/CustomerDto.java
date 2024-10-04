package lk.ijse.gdse.aad.possystemusingspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
