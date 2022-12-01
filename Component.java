import java.util.*;

public class Component {
    private String description;
    private double price;
    private String orderId;
    private String name;

    public Component(String name, String description, double price, String orderId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }
}
