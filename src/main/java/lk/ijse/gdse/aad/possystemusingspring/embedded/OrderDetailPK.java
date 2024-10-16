package lk.ijse.gdse.aad.possystemusingspring.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class OrderDetailPK implements Serializable {
    @Column
    private String orderId;
    @Column
    private String itemId;
}
