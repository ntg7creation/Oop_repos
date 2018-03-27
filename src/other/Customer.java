package other;

import Company.ComputerStore;
import InfoFiles.Computer;
import InfoFiles.Order;

public class Customer {
    private String name = "Rina";
    private Computer pc = null;

    public void creatNewOrder(ComputerStore store) {

	Order order = new Order();
	store.resiveOrder(this, order);
    }

    public void resiveComputer(Computer pc) {
	this.pc = pc;
    }
}
