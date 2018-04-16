package assiment1;

import assiment1.Company.*;
import assiment1.other.Customer;

public class programeStart {

    public static void main(String[] args) {
        String storeName = "Yossi-Computer";
        ComputerTechnician tec = new ComputerTechnician("Computer Technician", storeName);
        DeliveryPerson dp = new DeliveryPerson("Delivery Person", storeName);
        Importer im = new Importer("Importer", storeName);
        QAPerson qa = new QAPerson("QA", storeName);
        ComputerStore yossi = new ComputerStore(storeName, im, qa, tec, dp);

        Customer rina = new Customer("Rina");
        rina.createNewOrder(yossi, "I7 Processor", "Asus", "Microsoft", "LG");
    }
}
