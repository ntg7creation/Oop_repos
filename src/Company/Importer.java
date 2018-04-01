package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class Importer {

    
    public Importer() {

    }

    public Computer importComputer(Order order) {
	Supplier supplier = new Supplier();
	return supplier.prepareComputer(order);
    }
}
