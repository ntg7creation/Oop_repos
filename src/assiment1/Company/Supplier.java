package assiment1.Company;

import assiment1.InfoFiles.Computer;
import assiment1.InfoFiles.Order;

public class Supplier extends Employee{

    public Supplier(String name, String employer) {
        super(name, employer);
    }

    public Computer prepareComputer(Order order) {
        System.out.println(getName() + " prepares an unassembled computer.");
        String cpu = order.getCpu();
        String motherboard = order.getMotherboard();
        String peripherals = order.getPeripherals();
        String screen = order.getScreen();

        Computer computer = new Computer(cpu, motherboard, peripherals, screen);
        System.out.println(getName() + " returns the computer to " + getEmployer() + ".");
        return computer;
    }
}
