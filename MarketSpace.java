import java.util.*;

public class MarketSpace {
    public List<Computer> cart;
    public List<Map<Computer, Component>> products;

    public MarketSpace() {
        this.cart = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void loadProducts() {
        //connect with interface?
    }

    MarketSpace getInstance() {
        return null;
    }

    void addProductToComputer(Computer computer, Component component) {
        Map<Computer, Component> product = new HashMap<>();
        product.put(computer, component);
        this.products.add(product);
    }

    void removeProductFromComputer(Computer computer, Component component) {
        Map<Computer, Component> product = new HashMap<>();
        product.put(computer, component);
        this.products.remove(product);
    }

    void getProductsFromComputer(Computer computer) {
        for (Map<Computer, Component> product : products) {
            if ( product.containsKey(computer) ) {
                System.out.println(product.get(computer));
            }
        }
    }

    void addToCart(Computer computer) {
        this.cart.add(computer);
    }

    void removeFromCart(Computer computer) {
        this.cart.remove(computer);
        //check for computer key in products and remove without ConcurrentModificationException
        //this method is just for clear the cache of products in the cart
        //after removing computer from cart
        Iterator iterator = products.iterator();
        while (iterator.hasNext()) {
            Map<Computer, Component> product = (Map<Computer, Component>) iterator.next();
            if ( product.containsKey(computer) ) {
                iterator.remove();
            }
        }
    }

    void computerCheckout(Computer computer) {
        //prints out the computer description and price and the components
        System.out.println("Default computer: "+ computer.getDescription() + " Price: $" + computer.getPrice());
        double total = computer.getPrice();
        for (Map<Computer, Component> product : this.products) {
            if ( product.containsKey(computer) ) {
                System.out.println(product.get(computer).getName() + " " + product.get(computer).getDescription()+" $" +product.get(computer).getPrice());
                total += product.get(computer).getPrice();
            }
        }
        System.out.println("Total: " + total);


    }

    //uses sort strategy to sort by order id
    void sortById(boolean isAscending) {
        SortStrategy sortStrategy = new SortStrategy();
        sortStrategy.sortById(this.cart);
        if (!isAscending) {
            List<Computer> reversed = new ArrayList<Computer>();
            for (int i = this.cart.size() - 1; i >= 0; i--) {
                reversed.add(this.cart.get(i));
            }
            this.cart = reversed;
        }
    }

    //uses sort strategy to sort by price
    void sortByPrice(boolean isAscending) {
        SortStrategy sortStrategy = new SortStrategy();
        sortStrategy.sortByPrice(this.cart);
        if (!isAscending) {
            List<Computer> reversed = new ArrayList<Computer>();
            for (int i = this.cart.size() - 1; i >= 0; i--) {
                reversed.add(this.cart.get(i));
            }
            this.cart = reversed;
        }
    }
}
