package Company;

public class Order {
    private Computer computer;
    private String orderStatus;

    public Order(String parts){
        orderStatus = "New Order";
        computer = new Computer(parts);
    }

    public Computer getComputer() {
        return computer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
