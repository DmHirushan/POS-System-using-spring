package lk.ijse.gdse.aad.possystemusingspring.dto.impl;

import lk.ijse.gdse.aad.possystemusingspring.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto implements SuperDto {
    private String itemCode;
    private String itemName;
    private int itemQty;
    private double itemPrice;
}
