package lk.ijse.gdse.aad.possystemusingspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.aad.possystemusingspring.dao.ItemDao;
import lk.ijse.gdse.aad.possystemusingspring.dto.ItemDto;
import lk.ijse.gdse.aad.possystemusingspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDto itemDto) {
        itemDao.save(mapping.convertToEntity(itemDto));
    }

    @Override
    public void updateItem(String itemCode, ItemDto itemDto) {

    }
}
