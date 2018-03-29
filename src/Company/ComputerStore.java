package Company;

import InfoFiles.Computer;
import InfoFiles.Order;
import other.Customer;

public class ComputerStore {

    private String name = "Yossi";
    private Importer importer;
    private QAPerson qaPerson;
    private ComputerTechnician computertechnichian;
    private DeliveryPerson deliveryperson;
    private Customer customer; // we will change this to list if needed

    public ComputerStore() {

	this.importer = null;
	this.qaPerson = null;
	this.computertechnichian = null;
	this.deliveryperson = null;
	customer = null;
    }

    public ComputerStore(Importer importer, QAPerson qaPerson, ComputerTechnician computerTechnician,
	    DeliveryPerson deliveryPerson) {
	this.importer = importer;
	this.qaPerson = qaPerson;
	this.computertechnichian = computerTechnician;
	this.deliveryperson = deliveryPerson;
	customer = null;
    }

    public void resiveOrder(Customer customer, Order order) {

	this.customer = customer;
	System.out.println("Yossi-Computer forwards order to Importer.");
	Computer pc = importer.importComputer(order);
	
	System.out.println("Yossi-Computer requests a computer assembling to the Computer Technician.");
	pc = computertechnichian.assembleComputer(pc);
	
	System.out.println("Yossi-Computer requests a quality check from QA.");
	qaPerson.checkComputer(pc, order);
	
	System.out.println("Yossi-Computer forwards the computer to Delivery Person.");
	deliveryperson.deliverComputer(this.customer, pc);
    }

}
