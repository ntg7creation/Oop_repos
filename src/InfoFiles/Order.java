package InfoFiles;

import other.Customer;

public class Order {

    private String cpu;
    private String motherboard;
    private String peripherals;
    private String screen;
    private other.Customer customer;

    public Order() {
    }

    public Order(String cpu, String motherboard, String peripherals, String screen, Customer customer) {
	this.cpu = cpu;
	this.motherboard = motherboard;
	this.peripherals = peripherals;
	this.screen = screen;
	this.customer = customer;
    }

    public String getCpu() {
	return cpu;
    }

    public other.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(other.Customer customer) {
        this.customer = customer;
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
