package knap.jakub.itemsManagement.api;

import knap.jakub.itemsManagement.model.Item;
import knap.jakub.itemsManagement.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item")
    public ResponseEntity<List<Item>> getItem() {
        List<Item> items = itemService.getItemsById();
        return ResponseEntity.ok().body(items);
    }

    @PostMapping("/item")
    public ResponseEntity<?> saveItem(@RequestBody Item item) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/item").toUriString());
        return ResponseEntity.created(uri).body(itemService.saveItem(item));
    }

}
