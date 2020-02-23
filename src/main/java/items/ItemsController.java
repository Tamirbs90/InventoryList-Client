package items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
@RestController
public class ItemsController {

    @Autowired
    @Qualifier("ItemService")
    private IService<Item> itemService;

    @GetMapping("items")
    public ResponseEntity<Object> GetAllItems(){
        return Response.Ok(itemService.GetAll());
    }

    @GetMapping("items/{id}")
    public ResponseEntity<Object> GetItemByNumber(@PathVariable int id) {
        Item item = itemService.GetById(id);
        if(item==null)
            return Response.NotFound();
        return Response.Ok(item);
    }

    @GetMapping("items/{id}/withraw/{amount}")
    public ResponseEntity<Object> WithrawItemQuantity(@PathVariable int id, @PathVariable int amount){
        Item itemToWithraw = itemService.WithrawQuantity(id,amount);
        if(itemToWithraw==null)
            return Response.BadRequest();
        return Response.Ok(itemService.GetAll());
    }

    @GetMapping("items/{id}/deposit/{amount}")
    public ResponseEntity<Object> DepositItemQuantity(@PathVariable int id, @PathVariable int amount){
        Item itemToDeposit = itemService.DepositQuantity(id,amount);
        if(itemToDeposit==null)
            return Response.BadRequest();
        return Response.Ok(itemService.GetAll());
    }

    @PostMapping("items")
    public ResponseEntity<Object> AddItemToStock(@RequestBody Item item){
        itemService.AddToStock(item);
        return Response.Ok(itemService.GetAll());
    }

    @DeleteMapping("items/{id}")
    public ResponseEntity<Object> DeleteItemFromStock(@PathVariable int id){
        Item itemToDelete= itemService.DeleteFromStock(id);
        if(itemToDelete==null)
            return Response.NotFound();
        return Response.Ok(itemService.GetAll());
    }
}
