package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.dao.ItemDao;
import lk.ijse.gdse.aad.possystemusingspring.dao.OrderDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.OrderDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Item;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Mapping mapping;
    @Autowired
    private ItemDao itemDao;
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Override
    public void saveOrder(OrderDto orderDto) {
        logger.info("Attmpting to save order: {}", orderDto);
        orderDao.save(mapping.convertToEntity(orderDto));
        orderDto.getItems().forEach(itemDto -> {
            Item item = itemDao.getItemByItemCode(itemDto.getItemCode());
            item.setItemQty(item.getItemQty() - itemDto.getItemQty());
            itemDao.save(item);
            logger.info("Successfully saved order: {}", orderDto);
        });
    }
}
