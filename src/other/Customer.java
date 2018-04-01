package other;

import Company.ComputerStore;
import InfoFiles.Computer;
import InfoFiles.Order;

public class Customer {
    private String name;
    private Computer pc;

    public Customer(String name) {
	this.name = name;
	this.pc = null;
    }

    public void createNewOrder(ComputerStore store, Order order) {
	System.out.println("Client " + name + " orders computer from Yossi-Computer: I7 Processor,Asus,Microsoft,LG.");
	order.setCustomer(this);
	store.receiveOrder(order);
    }

    public void receiveComputer(Computer pc) {
	
	System.out.println("Client " + name + " receive: " + pc.toString());
	this.pc = pc;
    }
}
