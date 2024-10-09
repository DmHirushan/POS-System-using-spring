package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.dao.OrderDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDto;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDto orderDto) {
        orderDao.save(mapping.convertToEntity(orderDto));
    }
}
