package lk.ijse.gdse.aad.possystemusingspring.dto.impl;

import lk.ijse.gdse.aad.possystemusingspring.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto implements SuperDto {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
