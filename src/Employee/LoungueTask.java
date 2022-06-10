package Employee;

import java.util.List;

public interface LoungueTask {
    void reserveTable();
    boolean bookTable (int tableNumber, int capacity);
    void doTakeOrder(int tableNumber, List<Integer> numbersOfMenu);


}
