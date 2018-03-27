package Company;

import InfoFiles.Computer;
import InfoFiles.Order;
import other.Customer;

public class ComputerStore {

    private String name = "Yossi";
    private Importer importer;
    private QAPerson qaperson;
    private ComputerTechnician computertechnichian;
    private DeliveryPerson deliveryperson;
    private Customer customer; // we will change this to list if needed

    public ComputerStore() {

	this.importer = null;
	this.qaperson = null;
	this.computertechnichian = null;
	this.deliveryperson = null;
	customer = null;
    }

    public ComputerStore(Importer importer, QAPerson qaPerson, ComputerTechnician computerTechnician,
	    DeliveryPerson deliveryPerson) {
	this.importer = importer;
	this.qaperson = qaPerson;
	this.computertechnichian = computerTechnician;
	this.deliveryperson = deliveryPerson;
	customer = null;
    }

    public void resiveOrder(Customer customer, Order order) {

	this.customer = customer;

	Computer pc = importer.importComputer(order);
	computertechnichian.assembleComputer(pc);
	qaperson.checkComputer(pc, order);
	deliveryperson.deliverComputer(this.customer, pc);
    }

}
