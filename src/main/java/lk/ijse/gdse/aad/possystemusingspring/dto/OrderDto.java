package lk.ijse.gdse.aad.possystemusingspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto implements Serializable {
    private String orderId;
    private String date;
    private double subTotal;
    private double total;
    private CustomerDto customer;
    private List<ItemDto> items = new ArrayList<>();
}
