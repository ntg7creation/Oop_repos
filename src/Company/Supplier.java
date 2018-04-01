package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class Supplier {
    public Supplier(){

    }

    public Computer prepareComputer(Order order){
        System.out.println("Supplier prepares an unassembled computer.");
        String cpu = order.getCpu();
        String motherboard = order.getMotherboard();
        String peripherals = order.getPeripherals();
        String screen = order.getScreen();
        Computer computer = new Computer(cpu, motherboard, peripherals, screen);
        System.out.println("Supplier returns the computer to Importer.");
        return computer;
    }
}
