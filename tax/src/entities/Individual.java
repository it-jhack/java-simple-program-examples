package entities;

public class Individual extends TaxPayer {

    protected Double healthExpenses;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double healthExpenses) {
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double tax() {
        if (super.getAnnualIncome() >= 20_000.00) {
            return 0.25 * super.getAnnualIncome() - 0.5 * getHealthExpenses();
        }
        else {
            return super.tax() - 0.5 * getHealthExpenses();
        }
    }
}
