package assiment1.other;

import assiment1.Company.ComputerStore;
import assiment1.InfoFiles.Computer;
import assiment1.InfoFiles.Order;

public class Customer {
    private String name;
    private Computer pc;

    public Customer(String name) {
        this.name = name;
        this.pc = null;
    }

    public String getName() {
        return name;
    }

    public void createNewOrder(ComputerStore store, String cpu, String motherboard, String peripherals, String screen) {
        String format = "Client %s orders computer from %s: %s,%s,%s,%s.";
        System.out.println(String.format(format, getName(), store.getName(), cpu, motherboard, peripherals, screen));
        Order order = new Order(cpu, motherboard, peripherals, screen, this);
        store.receiveOrder(order);
    }

    public void receiveComputer(Computer pc) {
        System.out.println("Client " + name + " receive: " + pc.toString());
        this.pc = pc;
    }
}
