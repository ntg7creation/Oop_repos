package assiment1.Company;

public abstract class Employee {
    private String name;
    private String employer;

    public Employee(String name, String employer) {
        this.name = name;
        this.employer = employer;
    }

    public String getName() {
        return name;
    }

    public String getEmployer() {
        return employer;
    }
}
