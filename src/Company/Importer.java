package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class Importer extends Employee {

    public Importer(String name, String employer) {
        super(name, employer);
    }

    public Computer importComputer(Order order) {
        Supplier supplier = new Supplier("Supplier", getName());
        System.out.println(getName() + " forwards request to " + supplier.getName() + ".");
        Computer pc = supplier.prepareComputer(order);
        System.out.println(getName() + " returns the computer to " + getEmployer() + ".");
        return pc;
    }
}
