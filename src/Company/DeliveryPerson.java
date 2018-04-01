package Company;

import InfoFiles.Computer;
import other.Customer;

public class DeliveryPerson {

    private String name = "Delivery Person";

    public DeliveryPerson() {
    }

    public void deliverComputer(Customer customer, Computer pc) {
	System.out.println(name + " delivers the computer to Rina.");
	customer.receiveComputer(pc);
    }

}
