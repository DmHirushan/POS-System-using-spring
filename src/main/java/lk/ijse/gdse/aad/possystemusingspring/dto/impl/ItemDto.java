package lk.ijse.gdse.aad.possystemusingspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {
    private String itemCode;
    private String itemName;
    private int itemQty;
    private double itemPrice;
}
