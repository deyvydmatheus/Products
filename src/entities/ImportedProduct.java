package entities;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String productName, Double productPrice, Double customsFee) {
        super(productName, productPrice);
        this.customsFee = customsFee;
    }

    public Double getcustomsFee() {
        return customsFee;
    }

    @Override
    public final String priceTag() {
        return super.getProductName() + " $ " + getProductPrice() +  " (Customs Fee: " + String.format("%.2f", getcustomsFee()) + ")";
    }
}