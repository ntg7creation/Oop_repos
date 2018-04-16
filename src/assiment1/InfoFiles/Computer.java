package assiment1.InfoFiles;

public class Computer {
    private boolean assembled;
    private boolean tested;
    private String cpu;
    private String motherboard;
    private String peripherals;
    private String screen;

    public Computer(String cpu, String motherboard, String peripherals, String screen) {
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.peripherals = peripherals;
        this.screen = screen;
        assembled = false;
        tested = false;
    }

    public boolean isAssembled() {
        return assembled;
    }

    public void setAssembled(boolean assembled) {
        this.assembled = assembled;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public String getCpu() {
        return cpu;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getPeripherals() {
        return peripherals;
    }

    public String getScreen() {
        return screen;
    }

    @Override
    public String toString() {
        String format = "Computer: [%s,%s,%s,%s], assembled=%s, tested=%s";
        String output = String.format(format, cpu, motherboard, peripherals, screen, assembled, tested);
        return output;
    }
}
