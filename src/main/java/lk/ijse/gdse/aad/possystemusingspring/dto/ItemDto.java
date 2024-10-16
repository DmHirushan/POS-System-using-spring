package lk.ijse.gdse.aad.possystemusingspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.ijse.gdse.aad.possystemusingspring.customObj.ItemResponse;
import lk.ijse.gdse.aad.possystemusingspring.dto.SuperDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto implements SuperDto, ItemResponse {
    private String itemCode;
    private String itemName;
    private int itemQty;
    private double itemPrice;
    @JsonIgnore
    private List<Order> orders;
}
