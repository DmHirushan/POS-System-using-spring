package lk.ijse.gdse.aad.possystemusingspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class Order implements SuperEntity{
    @Id
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;
    private String date;
    private double subTotal;
    private double total;
}
