package assiment1.Company;

import assiment1.InfoFiles.Computer;
import assiment1.other.Customer;

public class DeliveryPerson extends Employee{

    public DeliveryPerson(String name, String employer) {
        super(name, employer);
    }

    public void deliverComputer(Customer customer, Computer pc) {
        System.out.println(getName() + " delivers the computer to " + customer.getName() + ".");
        customer.receiveComputer(pc);
    }
}
