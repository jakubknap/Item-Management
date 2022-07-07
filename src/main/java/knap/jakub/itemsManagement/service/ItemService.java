package knap.jakub.itemsManagement.service;

import knap.jakub.itemsManagement.model.Item;

import java.util.List;

public interface ItemService {

    Item saveItem(Item item);

    List<Item> getItemsById();

}
