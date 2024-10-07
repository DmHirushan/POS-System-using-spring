package lk.ijse.gdse.aad.possystemusingspring.controller;

import lk.ijse.gdse.aad.possystemusingspring.customObj.ItemResponse;
import lk.ijse.gdse.aad.possystemusingspring.dto.ItemDto;
import lk.ijse.gdse.aad.possystemusingspring.exception.DataPersistFailedException;
import lk.ijse.gdse.aad.possystemusingspring.exception.ItemNotFoundException;
import lk.ijse.gdse.aad.possystemusingspring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Void> saveItem(@RequestBody ItemDto itemDto){
        if (itemDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            try {
                itemService.saveItem(itemDto);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (DataPersistFailedException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PatchMapping("/{itemCode}")
    public ResponseEntity<Void> updateItem(@PathVariable ("itemCode") String itemCode, @RequestBody ItemDto itemDto){
        itemService.updateItem(itemCode, itemDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{itemCode}")
    public ItemResponse getItem(@PathVariable ("itemCode") String itemCode){
        return itemService.getItem(itemCode);
    }

    @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }

    @DeleteMapping("/{itemCode}")
    public ResponseEntity<Void> deleteItem(@PathVariable ("itemCode") String itemCode) {
        try {
            itemService.deleteItem(itemCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
