package lk.ijse.gdse.aad.possystemusingspring.dao;

import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDetailDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Order;
import lk.ijse.gdse.aad.possystemusingspring.entity.OrderDetail;
import lk.ijse.gdse.aad.possystemusingspring.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository <OrderDetail, OrderDetailPK> {
}
