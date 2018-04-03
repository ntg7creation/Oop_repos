package Company;

import InfoFiles.Computer;

public class ComputerTechnician extends Employee{

    public ComputerTechnician(String name, String employer) {
        super(name, employer);
    }

    public Computer assembleComputer(Computer pc) {
        System.out.println(getName() + " assembles a computer.");
        pc.setAssembled(true);

        System.out.println(getName() + " returns the computer to " + getEmployer() + ".");
        return pc;
    }
}
