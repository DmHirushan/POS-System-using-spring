package lk.ijse.gdse.aad.possystemusingspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDto implements SuperDto{
    private String orderID;
    private String itemCode;
    private double unitPrice;
    private int qty;
}
