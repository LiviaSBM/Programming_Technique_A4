public class ComputerDecorator implements Computer {
    private int orderId;
    private String description;
    private Double price;

    public ComputerDecorator(String description, Double price, int orderId) {
        this.orderId = orderId;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getOrderId() {
        return this.orderId;
    }
}

