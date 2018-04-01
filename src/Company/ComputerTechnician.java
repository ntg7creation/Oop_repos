package Company;

import InfoFiles.Computer;

public class ComputerTechnician {

    public ComputerTechnician() {
    }

    public Computer assembleComputer(Computer pc) {
        System.out.println("Technician assembles a computer.");
        pc.setAssembled(true);

        System.out.println("Technician returns the computer to Yossi-Computer.");
        return pc;
    }

}
