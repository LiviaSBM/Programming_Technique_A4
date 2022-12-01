import java.util.List;

public class SortStrategy {

    //sort by order id
    public void sortById(List<Computer> cart) {
        cart.sort((o1, o2) -> o1.getOrderId() - o2.getOrderId());
    }

    //sort by price
    public void sortByPrice(List<Computer> cart) {
        cart.sort((Computer c1, Computer c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
    }
}
