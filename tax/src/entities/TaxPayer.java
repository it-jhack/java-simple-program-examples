package entities;

public abstract class TaxPayer {
    // abstract cannot be instantiated, only inherited;

    protected String name;
    protected Double annualIncome;

    public TaxPayer() {
    }

    public TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Double tax() {
        return annualIncome * 0.15;
    }

}


//                                                                                                                                                       tinyurl.com/37cnczqt