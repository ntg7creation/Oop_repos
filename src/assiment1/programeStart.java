package assiment1;

import Company.*;
import InfoFiles.Order;
import other.Customer;

public class programeStart {
    public static void main(String[] args) {

        ComputerTechnician tec = new ComputerTechnician();
        DeliveryPerson dp = new DeliveryPerson();
        Importer im = new Importer();
        QAPerson qa = new QAPerson();

        ComputerStore yossi = new ComputerStore("Yossi-Computer", im, qa, tec, dp);

        Customer rina = new Customer("Rina");

        Order order = new Order("I7 Processor", "Asus", "Microsoft", "LG", null);
        rina.createNewOrder(yossi, order);

    }

}
