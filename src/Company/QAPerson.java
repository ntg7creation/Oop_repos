package Company;

import InfoFiles.Computer;
import InfoFiles.Order;

public class QAPerson {

    public QAPerson() {
    }

    public Boolean checkComputer(Computer pc, Order order) {

	System.out.println("QA checks the computer.");
	if (pc.getCPU().compareTo(order.getCPU()) != 0 
		| pc.getMotherboard().compareTo(order.getMotherboard()) != 0
		| pc.getPeripherals().compareTo(order.getPeripherals()) != 0
		| pc.getScreen().compareTo(order.getScreen()) != 0
		| !pc.isAssmbled()) {
	     return false; 
	}

	System.out.println("QA returns the computer to Yossi-Computer.");
	return true;
    }
}
