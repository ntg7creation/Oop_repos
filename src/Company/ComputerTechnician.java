package Company;

import InfoFiles.Computer;

public class ComputerTechnician {

    private String name = "Technician";

    public ComputerTechnician() {
    }

    public Computer assembleComputer(Computer pc) {
	System.out.println(name + " assembles a computer.");
	pc.setAssembled(true);

	System.out.println(name + " returns the computer to Yossi-Computer.");
	return pc;
    }

}
