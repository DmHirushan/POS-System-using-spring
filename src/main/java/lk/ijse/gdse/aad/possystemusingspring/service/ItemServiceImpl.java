package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.customObj.ItemErrorResponse;
import lk.ijse.gdse.aad.possystemusingspring.customObj.ItemResponse;
import lk.ijse.gdse.aad.possystemusingspring.dao.ItemDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.ItemDto;
import lk.ijse.gdse.aad.possystemusingspring.entity.Item;
import lk.ijse.gdse.aad.possystemusingspring.exception.DataPersistFailedException;
import lk.ijse.gdse.aad.possystemusingspring.exception.ItemNotFoundException;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDto itemDto) {
        if (itemDao.existsById(itemDto.getItemCode())) {
            throw new DataPersistFailedException("This Item Code already exists!");
        }else {
            Item savedItem = itemDao.save(mapping.convertToEntity(itemDto));
            if (savedItem == null && savedItem.getItemCode() == null) {
                throw new DataPersistFailedException("Can't save the Item!");
            }
        }

    }

    @Override
    public void updateItem(String itemCode, ItemDto incomingItem) {
        Optional<Item> existItem = itemDao.findById(itemCode);
        if (existItem == null) {
            throw new ItemNotFoundException("Item not found!");
        } else {
            existItem.get().setItemName(incomingItem.getItemName());
            existItem.get().setItemQty(incomingItem.getItemQty());
            existItem.get().setItemPrice(incomingItem.getItemPrice());
        }
    }

    @Override
    public ItemResponse getItem(String itemCode) {
        if (itemDao.existsById(itemCode)) {
            return mapping.convertToDto(itemDao.getItemByItemCode(itemCode));
        } else {
            return new ItemErrorResponse(0, "Item Not Found!");
        }
    }
}
