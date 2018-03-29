package InfoFiles;

public class Order {

    private String CPU;
    private String Motherboard;
    private String Peripherals;
    private String Screen;

    public Order() {
    }

    public String getCPU() {
	return CPU;
    }

    public String getMotherboard() {
	return Motherboard;
    }

    public String getPeripherals() {
	return Peripherals;
    }

    public String getScreen() {
	return Screen;
    }

    public void setCPU(String cPU) {
	CPU = cPU;
    }

    public void setMotherboard(String motherboard) {
	Motherboard = motherboard;
    }

    public void setPeripherals(String peripherals) {
	Peripherals = peripherals;
    }

    public void setScreen(String screen) {
	Screen = screen;
    }

}
