package Company;

import InfoFiles.Computer;
import other.Customer;

public class DeliveryPerson {

    public DeliveryPerson() {
    }

    public void deliverComputer(Customer customer, Computer pc) {
	System.out.println("Delivery Person delivers the computer to Rina.");
	customer.resiveComputer(pc);
    }

}
