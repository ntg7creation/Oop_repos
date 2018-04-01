package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class QAPerson {

    public QAPerson() {
    }

    public void checkComputer(Computer pc, Order order) {
        System.out.println("QA checks the computer.");
        boolean tested;
        if (pc.getCpu().compareTo(order.getCpu()) != 0
                | pc.getMotherboard().compareTo(order.getMotherboard()) != 0
                | pc.getPeripherals().compareTo(order.getPeripherals()) != 0
                | pc.getScreen().compareTo(order.getScreen()) != 0
                | !pc.isAssembled()) {
            tested = false;
        } else {
            tested = true;
        }

        System.out.println("QA returns the computer to Yossi-Computer.");
        pc.setTested(tested);
    }
}
