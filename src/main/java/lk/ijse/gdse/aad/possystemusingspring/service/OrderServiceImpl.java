package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.dao.CustomerDao;
import lk.ijse.gdse.aad.possystemusingspring.dao.ItemDao;
import lk.ijse.gdse.aad.possystemusingspring.dao.OrderDao;
import lk.ijse.gdse.aad.possystemusingspring.dao.OrderDetailDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.ItemDto;
import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDto;
import lk.ijse.gdse.aad.possystemusingspring.embedded.OrderDetailPK;
import lk.ijse.gdse.aad.possystemusingspring.entity.Customer;
import lk.ijse.gdse.aad.possystemusingspring.entity.Item;
import lk.ijse.gdse.aad.possystemusingspring.entity.Order;
import lk.ijse.gdse.aad.possystemusingspring.entity.OrderDetail;
import lk.ijse.gdse.aad.possystemusingspring.exception.CustomerNotFoundException;
import lk.ijse.gdse.aad.possystemusingspring.exception.ItemNotFoundException;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Override
    public void saveOrder(OrderDto orderDto) {
        logger.info("Attmpting to save order: {}", orderDto);
        Order order = mapping.convertToEntity(orderDto);
        var customer = customerDao.findById(orderDto.getCustomerId()).orElse(null);
        if (customer == null){
            throw new CustomerNotFoundException("Customer not found with Id: " + orderDto.getCustomerId());
        }
        order.setCustomer(customer);
        orderDao.save(order);
        for (ItemDto itemDto : orderDto.getItems()) {
            orderDetailDao.save(new OrderDetail(
                new OrderDetailPK(order.getOrderId(), itemDto.getItemCode()),
                itemDto.getItemQty(),
                    mapping.convertToEntity(itemDto),
                    order
            ));
            Item item = itemDao.findById(itemDto.getItemCode()).orElseThrow(() -> new ItemNotFoundException("Item not found with item code: " + itemDto.getItemCode()));
            item.setItemQty(item.getItemQty() - itemDto.getItemQty());
            itemDao.save(item);
        }
    }
}
