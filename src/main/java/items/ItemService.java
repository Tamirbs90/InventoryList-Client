package items;

/**
 * Created by Tamir on 22/11/2019.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Qualifier("ItemService")
public class ItemService implements IService<Item> {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> GetAll(){
        List<Item> items= new ArrayList<>();
        itemRepository.findAll().forEach(item -> items.add(item));
        return items;
    }

    public Item GetById(int id){
        return itemRepository.findById(id).orElse(null);
    }

    public Item WithrawQuantity(int id, int amountToWithraw){
        Item item= GetById(id);
        if(item==null)
            return null;
        int newAmount= item.getAmount()-amountToWithraw;
        if(newAmount < 0)
            return null;
        item.setAmount(newAmount);
        itemRepository.save(item);
        return item;
    }

    public Item DepositQuantity(int id, int amountToDeposit){;
        Item item= GetById(id);
        if(item==null)
            return null;
        item.setAmount(item.getAmount()+ amountToDeposit);
        itemRepository.save(item);
        return item;
    }

    public void AddToStock(Item item){
        itemRepository.save(item);
    }

    public Item DeleteFromStock(int id){
        Item itemToDelete = GetById(id);
        if(itemToDelete==null)
            return null;
        itemRepository.delete(itemToDelete);
        return itemToDelete;
    }
}
