package lk.ijse.gdse.aad.possystemusingspring.dao;

import lk.ijse.gdse.aad.possystemusingspring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository <Order, String> {
}
