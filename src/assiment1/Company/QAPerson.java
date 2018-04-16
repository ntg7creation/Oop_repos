package assiment1.Company;

import assiment1.InfoFiles.Computer;
import assiment1.InfoFiles.Order;

public class QAPerson extends Employee{

    public QAPerson(String name, String employer) {
        super(name, employer);
    }

    public void checkComputer(Computer pc, Order order) {
        System.out.println(getName() + " checks the computer.");
        boolean tested;
        if (pc.getCpu().compareTo(order.getCpu()) != 0 | pc.getMotherboard().compareTo(order.getMotherboard()) != 0
                | pc.getPeripherals().compareTo(order.getPeripherals()) != 0
                | pc.getScreen().compareTo(order.getScreen()) != 0 | !pc.isAssembled()) {
            tested = false;
        } else {
            tested = true;
        }

        pc.setTested(tested);
        System.out.println(getName() + " returns the computer to " + getEmployer() + ".");

    }
}
