package lk.ijse.gdse.aad.possystemusingspring.dao;

import lk.ijse.gdse.aad.possystemusingspring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository <Order, String> {
}
