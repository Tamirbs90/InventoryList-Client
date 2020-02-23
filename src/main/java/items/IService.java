package items;

import java.util.List;

/**
 * Created by Tamir on 18/02/2020.
 */
public interface IService<T> {
    List<T> GetAll();
    T GetById(int id);
    T WithrawQuantity(int id, int amountToWithraw);
    T DepositQuantity(int id, int amountToDeposit);
    void AddToStock(T item);
    T DeleteFromStock(int id);
}
