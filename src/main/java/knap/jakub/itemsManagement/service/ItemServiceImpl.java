package knap.jakub.itemsManagement.service;

import knap.jakub.itemsManagement.model.AppUser;
import knap.jakub.itemsManagement.model.Item;
import knap.jakub.itemsManagement.repository.AppUserRepository;
import knap.jakub.itemsManagement.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final AppUserRepository userRepository;

    @Override
    public Item saveItem(Item item) {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser user = userRepository.findByUsername(userName);
        log.info("Saving new item {} to the database", item.getName());
        return itemRepository.save(new Item(item.getName(), user));

    }

    @Override
    public List<Item> getItemsById() {
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser user = userRepository.findByUsername(userName);
        List<Item> allItems = itemRepository.findAll();
        List<Item> userItems = new ArrayList<>();
        for (Item item : allItems) {
            if (item.getUser().getId().equals(user.getId())) {
                userItems.add(item);
            }
        }
        log.info("Fetching all items for user: {}", user.getUsername());
        return userItems;
    }

}