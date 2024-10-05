package lk.ijse.gdse.aad.possystemusingspring.dao;

import lk.ijse.gdse.aad.possystemusingspring.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository <String, Item> {
}
