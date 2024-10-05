package lk.ijse.gdse.aad.possystemusingspring.service;

import lk.ijse.gdse.aad.possystemusingspring.dto.ItemDto;

public interface ItemService {
    public void saveItem(ItemDto itemDto);
    public void updateItem(String itemCode, ItemDto itemDto);

}
