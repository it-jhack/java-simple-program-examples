package entities;

public class ImportedProduct extends Product {

    protected Double customsFee;

    public ImportedProduct() {
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        Double totalPrice = getPrice() + customsFee;
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" $");
        sb.append(String.valueOf(String.format("%.2f", totalPrice)));
        sb.append(" (Customs fee: $");
        sb.append(String.format("%.2f", customsFee));
        sb.append(")");
        return sb.toString();
    }

}
