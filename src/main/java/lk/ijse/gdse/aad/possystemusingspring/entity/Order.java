package lk.ijse.gdse.aad.possystemusingspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class Order implements SuperEntity{
    @Id
    private String orderId;
    private String date;
    private double subTotal;
    private double total;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_details",
            joinColumns = @JoinColumn(name = "orderId", referencedColumnName = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "itemCode", referencedColumnName = "itemCode")
    )
    @JsonIgnore
    private List<Item> items;
}
