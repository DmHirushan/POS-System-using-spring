package lk.ijse.gdse.aad.possystemusingspring.entity;

import jakarta.persistence.*;
import lk.ijse.gdse.aad.possystemusingspring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customer")
@Entity
public class Customer implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
}
