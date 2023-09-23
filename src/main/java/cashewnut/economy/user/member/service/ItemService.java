package cashewnut.economy.user.member.service;

import cashewnut.economy.user.member.repository.ItemRepository;
import cashewnut.economy.user.member.domain.item.Item;
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
