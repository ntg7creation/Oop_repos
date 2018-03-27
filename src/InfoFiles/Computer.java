package InfoFiles;

public class Computer {
    private boolean assmbled;
    private String parts;

    public Computer(String parts){
        this.parts = parts;
        assmbled = false;
    }

    public String getParts() {
        return parts;
    }

    public boolean isAssmbled() {
        return assmbled;
    }

    public void setAssmbled(boolean assmbled) {
        this.assmbled = assmbled;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }
}
