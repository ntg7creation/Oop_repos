package InfoFiles;

public class Order {

    private String cpu;
    private String motherboard;
    private String peripherals;
    private String screen;

    public Order() {
    }

    public Order(String cpu, String motherboard, String peripherals, String screen){
        this.cpu = cpu;
        this.motherboard = motherboard;
        this.peripherals = peripherals;
        this.screen = screen;
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

    public void setCpu(String cPU) {
	cpu = cPU;
    }

    public void setMotherboard(String motherboard) {
	this.motherboard = motherboard;
    }

    public void setPeripherals(String peripherals) {
	this.peripherals = peripherals;
    }

    public void setScreen(String screen) {
	this.screen = screen;
    }

}
