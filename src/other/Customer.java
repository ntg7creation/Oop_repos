package other;

import Company.ComputerStore;
import InfoFiles.Computer;
import InfoFiles.Order;

public class Customer {
    private String name = "Rina";
    private Computer pc = null;

    public Customer(String name) {
	this.name = name;
    }

    public void creatNewOrder(ComputerStore store) {

	Order order = new Order();
	order.setCPU("I7 Processor");
	order.setMotherboard("Asus");
	order.setPeripherals("Microsoft");
	order.setScreen("LG");

	System.out.println("Client Rina orders computer from Yossi-Computer: I7 Processor,Asus,Microsoft,LG.");
	store.resiveOrder(this, order);
    }

    public void resiveComputer(Computer pc) {
	System.out.println("Client Rina receive: Computer [" + pc.getCPU() + ", " + pc.getMotherboard() + ", "
		+ pc.getPeripherals() + ", " + pc.getScreen() + "], " + "[assembled="+pc.isAssmbled() +", installed=true].");
	this.pc = pc;
    }
}
