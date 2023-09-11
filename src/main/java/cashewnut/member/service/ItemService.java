package cashewnut.member.service;

import cashewnut.member.domain.item.Item;
import cashewnut.member.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(readOnly = false)
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public Item findOne(Long ItemId) {
        return itemRepository.findOne(ItemId);
    }
}
