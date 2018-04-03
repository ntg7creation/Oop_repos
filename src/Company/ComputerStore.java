package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class ComputerStore {

    private String name;
    private Importer importer;
    private QAPerson qaPerson;
    private ComputerTechnician computerTechnician;
    private DeliveryPerson deliveryperson;
    private Order order;

    public ComputerStore(String name, Importer importer, QAPerson qaPerson, ComputerTechnician computerTechnician,
                         DeliveryPerson deliveryPerson) {
        this.name = name;
        this.importer = importer;
        this.qaPerson = qaPerson;
        this.computerTechnician = computerTechnician;
        this.deliveryperson = deliveryPerson;
    }

    public String getName() {
        return name;
    }

    public void receiveOrder(Order order) {
	this.order = order;
	
        System.out.println(getName() + " forwards order to " + importer.getName() + ".");
        Computer pc = importer.importComputer(order);

        System.out.println(getName() + " requests a computer assembling to " + computerTechnician.getName() + ".");
        pc = computerTechnician.assembleComputer(pc);

        System.out.println(getName() + " requests a quality check from " + qaPerson.getName() + ".");
        qaPerson.checkComputer(pc, order);

        System.out.println(getName() + " forwards the computer to " + deliveryperson.getName() + ".");
        deliveryperson.deliverComputer(order.getCustomer(), pc);
    }
}
