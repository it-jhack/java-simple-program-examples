package entities;

public class Company extends TaxPayer {

    protected Integer numberOfEmployees;

    public Company() {
        super();
    }

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        double taxRate = 0.16;
        if (numberOfEmployees >= 10) {
            taxRate = 0.14;
        }
        return super.getAnnualIncome() * taxRate;
    }
}
