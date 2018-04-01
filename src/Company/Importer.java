package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class Importer {

    public Importer(){

    }

    public Computer importComputer(Order order) {
        System.out.println("Importer forwards request to Supplier.");
        Supplier supplier = new Supplier();
        Computer pc =  supplier.prepareComputer(order);
        System.out.println("Importer returns the computer to Yossi-Computer.");
        return pc;
    }
}
